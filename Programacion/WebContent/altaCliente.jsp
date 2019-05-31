<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
</head>
<body>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	
		<%@include file = "/cabecera.jsp"%>
	
	<form method="POST" action=" MostrarClienteJSP ">
		Alta de clientes <br> <br>
		
		<h3>
			<b>Tipo de Cliente: </b>
		</h3>
		<b> <input type="radio" name="Persona" value="PersonaFisica"
			id="personaf" onclick="Checkradiobutton()" checked>PersonaFisica <input
			type="radio" name="Persona" value="PersonaJuridica" id="personaj"
			onclick="Checkradiobutton()">PersonaJuridica
			<table border="0">
				<tbody>
					<tr>
						<td>nombre:</td>
						<td><input name="nombre" id="nombre" required ></td>
					</tr>
					<tr>
						<td>apellido:</td>
						<td><input name="apellido" id="apellido" required>
						</td></tr>
					<tr>
						<td>dni:</td>
						<td><input type="number" name="dni" id="dni" required></td>
					</tr>
					<tr>
						<td>direccion:</td>
						<td><input name="direccion" id="direccion" required ></td>
					</tr>
					<tr>
						<td>razon social:</td>
						<td><input name="razonsocial" id="razonsocial" disabled required></td>
					</tr>
					<tr>
						<td>cuit:</td>
						<td><input  type="number" id="cuit" name="cuit" disabled required></td>
					</tr>
					<tr>
						<td><input type="submit" value="ENVIAR DATOS"></td>
					</tr>
				</tbody>
			</table>
			<p  align="right"><A href = "index.jsp" > Volver... </A> </p>
			<script>
				type = "text/JavaScript"
				function Checkradiobutton() {
					if (document.getElementById('personaf').checked) {
						document.getElementById('nombre').disabled = false;
						document.getElementById('apellido').disabled = false;
						document.getElementById('dni').disabled = false;
						document.getElementById('razonsocial').disabled = true;
						document.getElementById('cuit').disabled = true;
					
					} else if (document.getElementById('personaf').checked == false) {
						document.getElementById('nombre').disabled = true;
						document.getElementById('apellido').disabled = true;
						document.getElementById('dni').disabled = true;
						document.getElementById('razonsocial').disabled = false;
						document.getElementById('cuit').disabled = false;
				
					}
					else{
						
					}
				}
			</script>
		</b>
	</form>
</body>
</html>
