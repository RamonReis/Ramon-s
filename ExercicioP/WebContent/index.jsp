<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> HomePage</h1>

<c:if test="${sessionScope['logado'] eq 'yes' }">
	<h2>LOGADO</h2>
	<p><a href="ListaCarrosController"> Listar todos os carros</a></p>
	<p><a href="listaCarroId.jsp"> Listar carro por ID</a></p>
	<p><a href="cadastraCarro.jsp"> Cadastrar carro</a></p>
	<p><a href="deletaCarro.jsp"> Deletar carro ID</a></p>
	<form action="LogoutController" method="get">
	<p><input type="submit" value="Deslogar"></p>
	</form>
</c:if>

<c:if test="${sessionScope['logado'] != 'yes'}">
	<p><a href="login.html"> Ir para tela de Login</a></p>
	<p><a href="ListaCarrosController"> Listar todos os carros</a></p>
	<p><a href="listaCarroId.jsp"> Listar carro por ID</a></p>
	
</c:if>

</body>
</html>