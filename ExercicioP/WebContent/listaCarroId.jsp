<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista_Carro_ID</title>
</head>
<body>
	<h1>Lista Carro por ID</h1>
	
	<form action="ListaCarroId" method="get">
	<p>Id do carro: <input type="text" name ="idCarro" ></p>
	<input type="submit" value="Procurar"/>
	</form>
	
	<c:if test="${requestScope['carro'] != null}">
		ID Carro: ${carro.id} <br>
		Modelo: ${carro.modelo}<br>
		Cor: ${carro.cor}<br>
		Ano: ${carro.ano}<br>
		Marca: ${carro.marca}<br>
		Motor: ${carro.motor}<br>
		Número de portas: ${carro.numeroPortas}<br><br>
	</c:if>
	<br>
	<c:if test="${requestScope['carro'] == 'null'}">
		<p>Carro não encontrado!</p>
	</c:if>
	
	<p><a href="index.jsp">Retornar à Tela Inicial</a></p>
</body>
</html>