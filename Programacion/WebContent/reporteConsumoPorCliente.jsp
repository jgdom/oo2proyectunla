<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
</head>
<body>

	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<%@include file="/cabecera.jsp"%>
	<h1>Consumo de Cliente Entre Fechas:</h1>
	<form method="POST" action="  mostrarReporteDelCliente ">
		<h3>
			<b>Tipo de Cliente: </b>
		</h3>
		<b> <input type="radio" name="Persona" value="PersonaFisica"
			id="personaf" onclick="Checkradiobutton()" checked>PersonaFisica
			<input type="radio" name="Persona" value="PersonaJuridica"
			id="personaj" onclick="Checkradiobutton()">PersonaJuridica
			<table border="0">
				<tbody>
					<tr>
						<td>dni:</td>
						<td><input type="number" name="dni" id="dni" required></td>
					</tr>
					<tr>
						<td>cuit:</td>
						<td><input type="number" id="cuit" name="cuit" disabled
							required></td>
					</tr>

					<tr>
						<td>Fecha Inicial:</td>
						<td><input type="text" name="tiempo1" id="tiempo1" required></td>
					</tr>
					<tr>
						<td>Fecha Final:</td>
						<td><input type="text" name="tiempo2" id="tiempo2" required></td>
					</tr>

				</tbody>
			</table>
			<tr>
				<td><input type="submit" value="ENVIAR DATOS"></td>
			</tr> <script>
				$(function() {
					$.datepicker.parseDate("yy-mm-dd", "2007-01-26");
					$("#tiempo1").datepicker();
					$("#tiempo2").datepicker();
				});

				function Checkradiobutton() {
					if (document.getElementById('personaf').checked) {
						document.getElementById('cuit').disabled = true;
						document.getElementById('dni').disabled = false;

					} else if (document.getElementById('personaf').checked == false) {
						document.getElementById('dni').disabled = true;
						document.getElementById('cuit').disabled = false;

					} else {

					}
				}
			</script>
		</b>
	</form>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
		</tr>
	</table>
</body>
</html>
