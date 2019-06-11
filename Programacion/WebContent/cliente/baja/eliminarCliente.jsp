<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="/Programacion/images/logo-unla.png"></link>
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>
	<h3>
		<b>Tipo de Cliente: </b>
	</h3>
	<TABLE border="0">
		<TR>
			<form method="GET" action="busquedaDni.jsp ">
				<td><input type="submit" name="Persona" value="PersonaFisica"></td>
			</form>
			<form method="GET" action="busquedaCuit.jsp">
				<td><input type="submit" name="Persona" value="PersonaJuridica"></td>
			</form>
		</TR>
	</TABLE>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
			<td><A href="../clienteABM.jsp"> Volver... </A></td>
		</tr>
	</table>
</BODY>
</HTML>