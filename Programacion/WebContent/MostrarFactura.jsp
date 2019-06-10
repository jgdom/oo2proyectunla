<%@page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>


<%@page import = "datos.Factura"%>
<%@page import = "datos.ItemFactura"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1">
<title> OO2 proyect Unla</title>
</head>
<BODY>
	<%
		Factura factura = (Factura) request.getAttribute("factura");
		
	%>
	<table>
	<tbody>
	<tr>
		<td> nroMedidor: <%= factura.getNroSerieMedidor() %> </td>
	</tr>
	<tr>
		<td> observaciones : <%= factura.getObservaciones() %> </td>
	</tr>
	<tr>
		<td> Direccion: :  <%= request.getAttribute("mostrar")  %></td>
	</tr>
	   <% for (ItemFactura item : factura.getLstItemFactura()) { %>
        <tr>  
        <td> Consumo Total: <%= item.getCantidad() %></td>
        </tr>
        <tr>
        <td> Detalles: <%=item.getDetalle() %></td>
        </tr>
        <tr>
         <td>Precio por Kw: <%=item.getPrecioUnitario() %>  <%=item.getUnidad() %></td> 
        </tr>
    <% } %>
	</tr>	
	</tbody>
	</table>
	<A href = "index.jsp" > Volver... </A>
</BODY>
<script></script>
</html>