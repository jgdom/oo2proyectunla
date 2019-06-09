<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $.datepicker.parseDate( "yy-mm-dd", "2007-01-26" );
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>
		<%@include file = "/cabecera.jsp"%>
	
	<form method="POST" action=" traerFactura ">
		
			<table border="0">
				<tbody>
					<tr>
						<td> Ingrese Nro. De Medidor:  </td>
						<td><input type="number" name="nroMedidor" id="nroMedidor" required></td>
					</tr>
					<tr>
					
					<tr>
						<td> Fecha: </td>
						<td> <input type="text" name = "datepicker" id="datepicker" required> </td>
					</tr>
					
				</tbody>
			</table>
			<p  align="right"><A href = "index.jsp" > Volver... </A> </p>

		
		<tr>
			<td><input type="submit" value="ENVIAR DATOS"></td>
		</tr>
	</form>
</body>
</html>