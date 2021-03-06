package br.com.devjunior.login.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import impl.UsuarioRepositorioJDBC;

@WebServlet(urlPatterns = { "/nova" })
public class CriarConta extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4986673057527772154L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/NovaConta.jsp");
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
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/NovaConta.jsp");
			dispatcher.forward(req, resp);
		} else {
		try {
			if(aut.autenticar(novoContato) == null) {
				aut.criarUser(novoContato);
				
				req.setAttribute("sucesso", "Usuario cadastrado com sucesso");
				RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/NovaConta.jsp");
				dispatcher.forward(req, resp);
			
			} else {
				req.setAttribute("erro", "Email ja existe");
				RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/paginas/NovaConta.jsp");
				dispatcher.forward(req, resp);
			
			}
			
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());

		}

	}

}
}
