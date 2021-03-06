<%@page import="com.mysql.cj.jdbc.ha.ReplicationMySQLConnection"%>
<%@page import="impl.UsuarioRepositorioJDBC"%>
<%@page import="entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<link href="CSS/css.agenda/agenda.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<h2>&nbsp; &nbsp;Seja bem vindo !</h2>
	<a class="aa" href="${pageContext.request.contextPath}/logout">SAIR</a>
	<div class="agenda">
		<h3>Lista de contatos</h3>
		<p style="color: red;">${mensagemErro}</p>
		<table border="1" cellpadding="5" cellspacing="1">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Idade</th>
					<th>Telefone</th>
					<th>A??es</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${listaContatos}" var="contato">
					<tr>
						<td>${contato.nome}</td>
						<td>${contato.idade}</td>
						<td>${contato.telefone}</td>
						<td>&nbsp; &nbsp;<a
							href="${pageContext.request.contextPath}/editar?id=${contato.id}">Editar</a>
							&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath}/excluir?id=${contato.id}">Excluir</a>
							&nbsp;&nbsp;
						</td>
				</jstl:forEach>
			</tbody>
		</table>
		 <br>
		<a class="criar" href="${pageContext.request.contextPath}/incluir">Criar novo contato</a>
	</div>
</body>
</html>