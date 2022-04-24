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
import impl.ContatoRepositorioJDBC;
import interfaces.AgendaRepositorio;

@WebServlet(urlPatterns = { "/editar" })
public class AlterarContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1491784926963198295L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("usuarioLogado") != null) {
			int idContato = Integer.parseInt(req.getParameter("id"));
			AgendaRepositorio<Contato> agendaRepositorio = new ContatoRepositorioJDBC();
			try {
				List<Contato> contatos = agendaRepositorio.selecionar();
				var contatoSelecionado = contatos.stream().filter(c -> c.getId() == idContato).findFirst();
				if (contatoSelecionado.isPresent()) {
					req.setAttribute("contato", contatoSelecionado.get());
				} else {
					req.getSession().setAttribute("mensagemErro", "Este contato não existe.");
					resp.sendRedirect("/lista");
				}
			} catch (SQLException e) {
				req.getSession().setAttribute("mensagemErro", e.getMessage());
				resp.sendRedirect("/lista");
			}
			RequestDispatcher dispatcher = req.getServletContext()
					.getRequestDispatcher("/WEB-INF/paginas/AlterarContato.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contato contatoAlterado = new Contato();
		contatoAlterado.setNome(req.getParameter("nome"));
		contatoAlterado.setIdade(Integer.parseInt(req.getParameter("idade")));
		contatoAlterado.setTelefone(req.getParameter("telefone"));
		contatoAlterado.setId(Integer.parseInt(req.getParameter("id")));
		AgendaRepositorio<Contato> agendaRepositorio = new ContatoRepositorioJDBC();
		try {
			agendaRepositorio.editar(contatoAlterado);
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		resp.sendRedirect(req.getContextPath() + "/lista");
	}

}