package br.com.devjunior.login.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Usuario;
import impl.UsuarioRepositorioJDBC;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2706311068111453632L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/Login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioRepositorioJDBC aut = new UsuarioRepositorioJDBC();
		Usuario novoContato = new Usuario();
		novoContato.setEmail(req.getParameter("email"));
		novoContato.setSenha(req.getParameter("senha"));
		
		if(novoContato.getEmail().trim().isEmpty()) {
			req.setAttribute("erro2", "Preencha os campos");
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/Login.jsp");
			dispatcher.forward(req, resp);
		} else {
		try {
			Usuario usu = aut.autenticar(novoContato);
			
			if(usu != null) {
	
				HttpSession session = req.getSession();
				session.setAttribute("usuarioLogado", novoContato);
				
				resp.sendRedirect(req.getContextPath() + "/lista"); 

			}else {
				req.setAttribute("erro", "Email ou senha invalido");
				RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/Login.jsp");
				dispatcher.forward(req, resp);
				
			}
			
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());

		}

	}

}
}
