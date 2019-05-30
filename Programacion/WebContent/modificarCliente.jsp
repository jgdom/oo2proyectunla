<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">

</head>
<body>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	
		<%@include file = "/cabecera.jsp"%>
	

		Busqueda de clientes <br> <br>
		
		<h3>
			<b>Tipo de Cliente: </b>
		</h3>
			<form method="GET" action="clienteFisico.jsp">
				<input type="submit" name="Persona" >PersonaFisica 
			</form>
			<form method="GET" action="clientejuridico.jsp">
			<input  type="submit" name="Persona"  >PersonaJuridica
			</form>
	</form>
</body>
</html>
