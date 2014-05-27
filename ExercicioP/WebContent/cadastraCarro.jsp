<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cadastro de carros</h1>
<c:if test="${sessionScope['cadastrado'] eq 'yes' }">
	<p>Carro cadastrado com sucesso</p>
</c:if>
<form action="CadastCarController" method="get">
	<p>Modelo: <input type="text" name="modelo"  ></p>
	<p>Cor: <input type="text" name="cor"  ></p>
	<p>Ano: <input type="text" name="ano"  ></p>
	<p>Marca: <input type="text" name="marca"  ></p>
	<p>Motor: <input type="text" name="motor"  ></p>
	<p>Número de portas: <input type="text" name="numPortas"  ></p>
	
	<input type="submit" value="Cadastrar"/>
</form>
<p><a href="index.jsp">Retornar à Tela Inicial</a></p>
</body>
</html>