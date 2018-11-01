<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Sistema Web Mecâninca</h1>

	<a href="formcarro.jsp">Novo Carro</a>

	<h2>Lista de carros</h2>

	<jsp:useBean id="dao" class="dao.CarroDAO" />

	<c:set var="carros" value="${dao.getReadAll}" />

	<table>
		<c:forEach var="carro" items="${carros}">
			<tr>
				<td>${carro.modelo}</td>
				<td>${carro.marca}</td>
				<td>${carro.tipoCombustivel}</td>
				<td>${carro.valor}</td>
				<td><a href="ServletCarro?action=edit&id=${carro.id}">Editar</a></td>
				<td><a href="ServletCarro?action=delete&id=${carro.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>