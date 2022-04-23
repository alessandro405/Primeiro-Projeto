<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iclus�o de contato</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/lista">Inicio</a>
	<h2>Inclus�o de contato</h2>
	<form method = "post" action="${pageContext.request.contextPath}/incluir">
		<p>Nome:</p>
		<p><input type= "text" name= "nome"></p>
		<p>Idade:</p>
		<p><input type= "number" name= "idade"></p>
		<p>Telefone:</p>
		<p><input type= "text" name= "telefone"></p>
		<button type= "submit">Salvar</button>
	</form>
</body>
</html>