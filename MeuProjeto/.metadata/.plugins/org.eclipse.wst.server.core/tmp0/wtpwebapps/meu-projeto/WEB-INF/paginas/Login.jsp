<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<!DOCTYPE html>
<html>
<head>
	<link href="CSS/css.login/login.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login de usuario</title>
</head>
<body>
	<%
		String erro = (String) request.getAttribute("erro");
		String erro2 = (String) request.getAttribute("erro2");
	%> 
	<div class="login-box">
	<h2>Login de usuario</h2>
	<form method = "post" action="${pageContext.request.contextPath}/login">
		<div class="user-box">
		<p>Email</P>
		<p><input type= "text" name= "email"></p>
		</div>
		<div class="user-box">
		<p>Senha</P>
		<p><input type= "text" name= "senha"></p>
		</div>
		<a href="#">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
		<button type= "submit" >ENTRAR</button>
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="nova-conta" href="${pageContext.request.contextPath}/nova">Nova conta</a>
		<p><%
			if(erro != null){
				out.print(erro);
			} else if(erro2 != null){
				out.print(erro2);
			}
		%></P>
	</form>
	</div>
	<footer>AL Software Developer</footer>
</body>
</html>