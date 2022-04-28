<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html>
<head>
<link href="CSS/css.login/novaConta.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Criar nova conta</title>
</head>
<body>
	<% 
	String erro = (String) request.getAttribute("erro");
	String erro2 = (String) request.getAttribute("erro2");
	String sucesso = (String) request.getAttribute("sucesso");
	
	%>
	<a class="login" href="${pageContext.request.contextPath}/login">LOGIN</a>
	<div class="nova-conta">
		<h2>Criar nova conta</h2>
		<form method="post" action="${pageContext.request.contextPath}/nova">
			<div class="user-box">
				<p>Email</P>
				<p>
					<input type="text" name="email">
				</p>
			</div>
			<div class="user-box">
				<p>Senha</P>
				<p>
					<input type="text" name="senha">
				</p>
			</div>
			<a href="#"> 
			<span></span> 
			<span></span> 
			<span></span> 
			<span></span>
			<button type="submit">CRIAR</button>
			</a>
			<p><%
				if(erro != null){
					out.print(erro);
				} else if(erro2 != null){
					out.print(erro2);
				} else if(sucesso != null){
					out.print(sucesso);
				}
		%></p>
	</form>
	</div>
</body>
</html>