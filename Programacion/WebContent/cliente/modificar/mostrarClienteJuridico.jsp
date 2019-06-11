<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="datos.PersonaJuridica"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="/Programacion/images/logo-unla.png"></link>
</head>
<BODY>
	<%@include file="/cabecera.jsp"%>
	<%
		PersonaJuridica cliente = (PersonaJuridica) request.getAttribute("cliente");
	%>
	<form method="POST" action=" modificarClienteJ ">
		<input id="cuit" name="cuit" type="hidden"
			value=<%=cliente.getCuit()%>>
		<table>
			<tbody>
				<tr>
					<td>Razon Social: <%=cliente.getRazonSocial()%>
					</td>
					<td></td>
					<td>Nueva Razon Social:<input name="razon social"
						id="razon social">
					</td>
				</tr>
				<tr>
					<td>Direccion: <%=cliente.getDireccion()%>
					<td></td>
					<td>Nueva Direccion:<input name="direccion" id="direccion">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="ENVIAR DATOS"></td>
					<td><a href="index.jsp">Inicio</a>
					<td><a href="modificarCliente.jsp">Volver...</a>
			</tbody>
		</table>
	</form>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
			<td><A href="cliente/modificar/busquedaCuit.jsp"> Volver... </A></td>
		</tr>
	</table>
</BODY>
</html>