<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<link href="CSS/css.agenda/alterar.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Alterar contato ${contato.nome}</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/lista">INICIO</a>
	<div class="alterar">
		<h2>Alterar contato: ${contato.nome}</h2>
		<form method="post" action="${pageContext.request.contextPath}/editar">
			<input type="hidden" name="id" value="${contato.id}">
			<p>Nome:</p>
			<p>
				<input type="text" name="nome" value="${contato.nome}">
			</p>
			<p>Idade:</p>
			<p>
				<input type="number" name="idade" value="${contato.idade}">
			</p>
			<p>Telefone:</p>
			<p>
				<input type="text" name="telefone" value="${contato.telefone}">
			</p>
			<button type="submit">Salvar</button>
		</form>
	</div>
</body>
</html>