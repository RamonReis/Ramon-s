<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleta_Carro</title>
</head>
<body>
	<h1>Deletar Carro</h1>
	<c:if test="${requestScope['deletado'] eq 'yes'}">
		<h3> Carro deletado com Sucesso</h3>
	</c:if>
	
	<form action="DeletaCarro" method="get">
	<p>Id do carro: <input type="text" name ="idCarroDeletar" ></p>
	<input type="submit" value="Deletar"/>
	</form>
	
</body>
<p><a href="index.jsp">Retornar à Tela Inicial</a></p>
</html>