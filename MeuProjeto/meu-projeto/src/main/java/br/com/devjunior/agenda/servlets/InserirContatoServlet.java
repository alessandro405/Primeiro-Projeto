package br.com.devjunior.agenda.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Contato;
import impl.ContatoRepositorioJDBC;
import interfaces.AgendaRepositorio;

@WebServlet(urlPatterns = { "/incluir" })
public class InserirContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6549035639221224855L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			RequestDispatcher dispatcher = req.getServletContext()
					.getRequestDispatcher("/WEB-INF/paginas/InserirContato.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgendaRepositorio<Contato> agendaRepositorio = new ContatoRepositorioJDBC();
		Contato novoContato = new Contato();
		novoContato.setNome(req.getParameter("nome"));
		novoContato.setIdade(Integer.parseInt(req.getParameter("idade")));
		novoContato.setTelefone(req.getParameter("telefone"));
		try {
			agendaRepositorio.inserir(novoContato);

		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());

		}
		resp.sendRedirect(req.getContextPath() + "/lista");

	}

}
