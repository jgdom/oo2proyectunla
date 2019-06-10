<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>
	<h3>
		<b>Tipo de Cliente: </b>
	</h3>
	<TABLE border="0">
		<TR>
			<form method="GET" action="BusquedaEliminarFisico.jsp ">
				<td><input type="submit" name="Persona" value="PersonaFisica"></td>
			</form>
			<form method="GET" action="busquedaEliminarJuridico.jsp">
				<td><input type="submit" name="Persona" value="PersonaJuridica"></td>
			</form>
		</TR>
		<TR>
			<FORM NAME="buttonbar">
				<td><INPUT TYPE="button" VALUE="Volver"
					onClick="history.back()"></td>
			</FORM>
		</TR>
	</TABLE>
</BODY>
</HTML>