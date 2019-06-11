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
	<form method="POST" action=" /Programacion/eliminarCliente ">
		<input id="dni" name="dni" type="hidden"
			value=<%=cliente.getdPersonales().getDni()%>>
		<table>
			<tbody>
				<tr>
					<td>DNI: <%=cliente.getdPersonales().getDni()%>
					</td>
				</tr>
				<tr>
					<td>Apellido: <%=cliente.getdPersonales().getApellido()%>
					</td>
				</tr>
				<tr>
					<td>Nombre :<%=cliente.getdPersonales().getNombre()%>
					</td>
				</tr>
				<tr>
					<td>Direccion : <%=cliente.getDireccion()%>
					</td>
				</tr>

				<tr>
					<td><input type="submit" value="ELIMINAR"></td>
				</tr>

			</tbody>
		</table>
		<table align="center">
			<tr>
				<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
				<td><A href="cliente/baja/busquedaDni.jsp"> Volver... </A></td>
			</tr>
		</table>

	</form>
</BODY>
</html>