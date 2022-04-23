package br.com.devjunior.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Contato;
import impl.ContatoRepositorioJDBC;
import interfaces.AgendaRepositorio;

@WebServlet(urlPatterns = {"/excluir"})
public class ExcluirContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4340020117877740532L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idContato = Integer.parseInt(req.getParameter("id"));
		Contato contatoExcluido = new Contato();
		contatoExcluido.setId(idContato);
		AgendaRepositorio<Contato> agendaRepositorio = new ContatoRepositorioJDBC();
		try {
			agendaRepositorio.excluir(contatoExcluido);
		} catch (SQLException e) {
			req.getSession().setAttribute("mensagemErro", e.getMessage());
		}
		resp.sendRedirect(req.getContextPath() + "/lista");
	
	}

}
