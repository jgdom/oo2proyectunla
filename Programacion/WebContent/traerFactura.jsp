<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<script>
$(function() {
    $("#datepicker").datepicker({
        startView: 1,
        minViewMode: 1,
      	 beforeShowMonth: function (Date) {
            var day = Date.getMonth();
            if (day % 2 == 0) return true;
            else return false;
        },
    language: "es"
    });
  });
</script>
</head>
<body>
	<%@include file="/cabecera.jsp"%>
	<h1>Factura</h1>
	<form method="POST" action=" traerFactura ">

		<table border="0">
			<tbody>
				<tr>
					<td>Ingrese Nro. De Medidor:</td>
					<td><input type="number" name="nroMedidor" id="nroMedidor"  min="1" required></td>
				</tr>
				<tr>
				<tr>
					<td>Fecha:</td>
					<td><input type="text" onkeydown="return false" name="datepicker" id="datepicker" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="ENVIAR DATOS"></td>
				</tr>
			</tbody>
		</table>
		
	</form>
	<table align="center">
		<tr>
			<td><A href="/Programacion/index.jsp"> Inicio... </A></td>
		</tr>
	</table>
</body>
</html>