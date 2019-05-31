<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
</head>
<body>
	<%@include file="/cabecera.jsp"%>

	<form method="POST" action=" MostrarClienteJSP ">
		Busqueda de clientes <br> <br>

		<h3>
			<b>Tipo de Cliente: </b>
		</h3>
		<b>
			<table border="0">
				<tbody>
					<tr>
						<td>nombre</td>
						<td><input name="nombre" id="nombre" required></td>
					</tr>
					<tr>
						<td>apellido:</td>
						<td><input name="apellido" id="apellido" required></td>
					</tr>
					<tr>
						<td>dni:</td>
						<td><input type="number" id="cuit" name="cuit" required></td>
					</tr>
					</tr>
					<tr>
						<td><input type="submit" value="ENVIAR DATOS"></td>
					</tr>
					<TR>
						<FORM NAME="buttonbar">
							<td><INPUT TYPE="button" VALUE="Volver"
								onClick="history.back()"></td>
						</FORM>
					</TR>
				</tbody>
			</table>

		</b>
	</form>
</body>
</html>
