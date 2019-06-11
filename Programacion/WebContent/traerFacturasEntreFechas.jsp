<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$.datepicker.parseDate("yy-mm-dd", "2007-01-26");
		$("#tiempo1").datepicker();
		$("#tiempo2").datepicker();
	});
</script>
</head>
<body>
	<%@include file="/cabecera.jsp"%>
	<h1>Facturas Emitidas Entre Fechas:</h1>
	<form method="POST" action=" traerFacturaEntreFechas ">

		<table border="0">
			<tbody>
				<tr>
					<td>Fecha:</td>
					<td><input type="text" name="tiempo1" id="tiempo1" required>
					</td>
				</tr>
				<tr>
					<td>Fecha:</td>
					<td><input type="text" name="tiempo2" id="tiempo2" required>
					</td>
				</tr>
			</tbody>
		</table>
		<tr>
			<td><input type="submit" value="ENVIAR DATOS"></td>
		</tr>
	</form>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
		</tr>
	</table>
</body>
</html>