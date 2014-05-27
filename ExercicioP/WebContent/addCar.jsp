<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar carro</title>
</head>
<body>
<h1> Adicionar carro </h1>
<c:if test="${sessionScope['logado'] == null }">
	
</c:if>
	<form action="LoginController" method="post">
		<p>ID: <input type="text" name ="id" id="username"></p>
		<p>Modelo: <input type="password" name="password"  id="password"></p>
		<p>Cor: <input type="text" name ="username" id="username"></p>
		<p>Ano: <input type="text" name ="username" id="username"></p>
		<p>Marca: <input type="text" name ="username" id="username"></p>
		<p>Motor: <input type="text" name ="username" id="username"></p>
		<p>Número de Portas: <input type="text" name ="username" id="username"></p>
		
		<input type="submit" value="Cadastrar Carro"/>
</form>

</body>
</html>