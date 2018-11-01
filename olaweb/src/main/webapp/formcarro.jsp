<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Sistema Web Mecânica</h1>
	<h2>Novo Carro</h2>

	<form method="post" action="ServletCarro">
	    <input type="hidden" name="id" value="${carro.id}">
		<label>Modelo:</label> <input name="modelo" type="text" value="${carro.modelo}"/> <br>
		<label>Marca:</label> <input name="marca" type="text" value="${carro.marca}"/> <br>
		<label>TipoCombustivel:</label> <input name="tipocombustivel" type="text" value="${carro.tipocombustivel}"/> <br>
		<label>Valor:</label> <input name="valor" type="text" value="${carro.valor}"/>
		<input type="submit" value="Salvar" />
	</form>

</body>

</html>