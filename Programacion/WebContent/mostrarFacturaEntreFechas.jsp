<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>OO2 proyect Unla</title>
</head>
<BODY>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<h1>Facturas:</h1>
	<table style="width: 100%;" id="Table2"
		class="table table-bordered table-striped h-0">
		<tbody>
			<tr>
				<th colspan="5"> Factura </th>
				<th colspan="4">Item Facturas</th>
			</tr>
			<tr>
				<th>IdFactura</th>
				<th>N° Serie Medidor</th>
				<th>Id Cliente</th>
				<th>fecha de emision de factura</th>
				<th>fecha de consumo</th>
				<th>Detalle</th>
				<th>Precio Unitario</th>
				<th>Cantidad consumida</th>
				<th>Unidad Medicion</th>
			</tr>
			<c:forEach var="facturas" items="${factura}">

				<tr>
					<td>${facturas.getIdFactura()}</td>
					<td>${facturas.getNroSerieMedidor()}</td>
					<td>${facturas.getidCliente() }</td>
					<td>${facturas.getFecha()}</td>
					<td>${facturas.getObservaciones()}</td>
					<c:forEach var="itemfactura" items="${lista}">

							<c:if
								test="${ itemfactura.getFactura().getIdFactura() == facturas.getIdFactura() }">
							
									<td>${itemfactura.getDetalle()}</td>
									<td>${itemfactura.getPrecioUnitario()}</td>
									<td>${itemfactura.getCantidad()}</td>
									<td>${itemfactura.getUnidad()}</td>
							</c:if>


						</c:forEach>
			
			</c:forEach>

		</tbody>
	</table>
	<A href="index.jsp"> Volver... </A>
</BODY>
<script></script>
</html>