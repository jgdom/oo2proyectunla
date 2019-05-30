<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">

</head>
<body>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	
		<%@include file = "/cabecera.jsp"%>
	
	<form method="POST" action=" MostrarClienteJSP ">
		Busqueda de clientes <br> <br>
		
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
						<td>apellido :</td>
						<td><input name="apellido" id="apellido" required>
						</td>
						<td>dni</td>
						<td><input type="number" name="dni" id="dni" required></td>
						<td>direccion</td>
						<td><input name="direccion" id="direccion" required ></td>
						<td>razon social:</td>
						<td><input name="razonsocial" id="razonsocial" disabled required></td>
						<td>cuit</td>
						<td><input  type="number" id="cuit" name="cuit" disabled required></td>
					</tr>
					<tr>
						<td><input type="submit" value="ENVIAR DATOS"></td>
					</tr>
				</tbody>
			</table> 
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
