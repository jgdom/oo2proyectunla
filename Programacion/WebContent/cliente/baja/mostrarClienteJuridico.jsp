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
	<form method="POST" action=" /Programacion/eliminarCliente ">
		<input id="cuit" name="cuit" type="hidden"
			value=<%=cliente.getCuit()%>>
		<table>
			<tbody>
				<tr>
					<td>CUIT: <%=cliente.getCuit()%>
					</td>
				</tr>
				<tr>
					<td>Razon Social: <%=cliente.getRazonSocial()%>
					</td>
				</tr>
				<tr>
					<td>Direccion: <%=cliente.getDireccion()%>
				</tr>
				<tr>
					<td><input type="submit" value="ELIMINAR"></td>
			</tbody>
		</table>
	</form>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
			<td><A href="cliente/baja/eliminarCliente.jsp"> Volver... </A></td>
		</tr>
	</table>
</BODY>
</html>