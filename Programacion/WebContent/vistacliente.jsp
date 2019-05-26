<%@page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@page import = "datos.Cliente"%>
<%@page import = "datos.PersonaFisica"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
<title> OO2 proyect Unla</title>
</head>
<BODY>
	<%@include file = "/cabecera.jsp"%>
	<% PersonaFisica datos=(PersonaFisica)request.getAttribute( "datos" ); %>
	<BR>
	
	 <BR>
		Direccion : <%= datos.getDireccion() %>
		<BR>
		ID: <%= datos.getIdCliente() %>
			<BR>
		nombre <%= datos.getdPersonales().getNombre() %>
		<BR>
		apellido <%= datos.getdPersonales().getApellido() %>
		<BR>
	<A href = "/index.jsp" > Volver... </A>
</BODY>
</html>