<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista_Carros</title>
</head>
<body>
	<h1>Carros no Banco de Dados</h1>
	<c:if test="${sessionScope['lista'] != 'null' }">
		<c:forEach var="carro" items="${lista}">
			ID Carro: ${carro.id} <br>
			Modelo: ${carro.modelo}<br>
			Cor: ${carro.cor}<br>
			Ano: ${carro.ano}<br>
			Marca: ${carro.marca}<br>
			Motor: ${carro.motor}<br>
			Número de Portas: ${carro.numeroPortas}<br><br>
		</c:forEach>
		
	</c:if>
	<c:if test="${sessionScope['lista'] == 'null' }">
		<p> Lista Vazia </p>
	</c:if>
	
	<p><a href="index.jsp">Retornar à Tela Inicial</a></p>
</body>
</html>