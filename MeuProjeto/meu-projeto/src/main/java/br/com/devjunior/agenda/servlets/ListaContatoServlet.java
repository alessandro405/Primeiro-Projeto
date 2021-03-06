package br.com.devjunior.agenda.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Contato;
import entidades.Usuario;
import impl.ContatoRepositorioJDBC;
import interfaces.AgendaRepositorio;

@WebServlet(urlPatterns = { "/lista" })
public class ListaContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2796250352533875150L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("usuarioLogado") != null) {
			AgendaRepositorio<Contato> agendaRepositorio = new ContatoRepositorioJDBC();
			try {
				List<Contato> contato = agendaRepositorio.selecionar();
				req.setAttribute("listaContatos", contato);
			} catch (SQLException e) {
				req.setAttribute("mensagemErro", e.getMessage());
			}
			Object mensagemErro = req.getSession().getAttribute("mensagemErro");
			if (mensagemErro != null) {
				req.setAttribute("mensagemErro", mensagemErro.toString());
				req.getSession().removeAttribute("mensagemErro");
			}
			{
				RequestDispatcher dispatcher = req.getServletContext()
						.getRequestDispatcher("/WEB-INF/paginas/ListaContato.jsp");
				dispatcher.forward(req, resp);
			}

		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}
}