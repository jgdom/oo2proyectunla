<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="datos.PersonaJuridica"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Francés</title>
</head>
<BODY>
	<%@include file="/cabecera.jsp"%>
	<%
	PersonaJuridica cliente = (PersonaJuridica) request.getAttribute("cliente");
	%>
	<BR> Cuit:
	<%= cliente.getCuit() %>
	<BR> Direccion:
	<%= cliente.getDireccion() %>
	<BR> Razon social:
	<%= cliente.getRazonSocial() %>
	<A href="index.jsp"> Volver... </A>
</BODY>
</html>
