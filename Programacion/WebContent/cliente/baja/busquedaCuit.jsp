<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="/Programacion/images/logo-unla.png"></link>
</head>
<body>
	<%@include file="/cabecera.jsp"%>

	<form method="POST" action=" /Programacion/buscarCuit ">
		Ingrese Cuit:
		<table border="0">
			<tbody>
				<tr>
					<td><input type="number" name="cuit" id="cuit" required></td>
				</tr>
				<tr>
			</tbody>
		</table>
		<tr>
			<td><input type="submit" value="ENVIAR DATOS"></td>
		</tr>
	</form>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
			<td><A href="eliminarCliente.jsp"> Volver... </A></td>
		</tr>
	</table>
</body>
</html>
