<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
</head>
<body>
		<%@include file = "/cabecera.jsp"%>
	
	<form method="POST" action=" buscarDni ">
		Ingrese dni: 
			<table border="0">
				<tbody>
					<tr>
				
						<td><input type="number" name="dni" id="dni" required></td>
					</tr>
					<tr>

				</tbody>
			</table>
			<p  align="right"><A href = "index.jsp" > Volver... </A> </p>

		<tr>
			<td><input type="submit" value="ENVIAR DATOS"></td>
		</tr>
	</form>
</body>
</html>
