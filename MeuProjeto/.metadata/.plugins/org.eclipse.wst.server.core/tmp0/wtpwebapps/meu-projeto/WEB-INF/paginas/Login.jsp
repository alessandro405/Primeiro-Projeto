<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<!DOCTYPE html>
<html>
<head>
	<link href="CSS/css.login/login.css" rel="stylesheet">
    <link href="CSS/css.login/css2.css" rel="stylesheet">
    <link href="CSS/css.login/css3.css" rel="stylesheet">
    <link href="CSS/css.login/css4.css" rel="stylesheet">
   <!--  <link href="CSS/css.login/css5.css" rel="stylesheet"> -->
    <!-- <link href="CSS/css.login/css6.css" rel="stylesheet"> -->
<meta charset="ISO-8859-1">
<title>Login de Usuario</title>
</head>
<body>

	<%
		String erro = (String) request.getAttribute("erro");
	%> 
	<div class="login-box">
	<h2>Login de Usuario</h2>
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
		<button type= "submit" >LOGIN</button>
		</a>
		<p><%
			if(erro != null){
				out.print(erro);
			}
		%></P>
	</form>
	</div>
</body>
</html>