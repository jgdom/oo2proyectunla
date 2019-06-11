<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="/Programacion/images/logo-unla.png"></link>
</head>
<body>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

	<%@include file="/cabecera.jsp"%>


	Busqueda de clientes
	<br>
	<br>

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
</body>
</html>
