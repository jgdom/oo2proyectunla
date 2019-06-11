<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="datos.PersonaFisica"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="/Programacion/images/logo-unla.png"></link>
</head>
<BODY>
	<%@include file="/cabecera.jsp"%>
	<%
		PersonaFisica cliente = (PersonaFisica) request.getAttribute("cliente");
	%>
	<form method="POST" action=" /Programacion/modificarClienteF ">
		<input id="dni" name="dni" type="hidden"
			value=<%=cliente.getdPersonales().getDni()%>>
		<table>
			<tbody>
				<tr>
					<td>Apellido: <%=cliente.getdPersonales().getApellido()%>
					</td>
					<td></td>
					<td>Nuevo Apellido:<input name="apellido" id="apellido"
						required>
					</td>
				</tr>
				<tr>
					<td>Nombre :<%=cliente.getdPersonales().getNombre()%>
					</td>
					<td></td>
					<td>Nuevo Nombre:<input name="nombre" id="nombre" required></td>
				</tr>
				<tr>
					<td>Direccion : <%=cliente.getDireccion()%>
					</td>
					<td></td>
					<td>Nueva direccion:<input name="direccion" id="direccion"
						required></td>
				</tr>

				<tr>
					<td><input type="submit" value="ENVIAR DATOS"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
			<td><A href="cliente/modificar/busquedaDni.jsp"> Volver... </A></td>
		</tr>
	</table>
</BODY>
</html>
