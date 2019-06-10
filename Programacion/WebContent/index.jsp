<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>EdeUNLa</TITLE>
<link rel="icon" href="images/logo-unla.png"></link>
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>
		<TABLE border="0">
			<TR>
			<FORM action=" altaCliente.jsp ">
				<TD><INPUT type="submit" value="Agregar cliente"> </TD>
			</FORM>
			<FORM action=" modificarCliente.jsp ">
				<TD><INPUT type="submit" value="Modificar cliente"> </TD>
			</FORM>	
			<FORM action=" eliminarCliente.jsp ">
				<TD><INPUT type="submit" value="Eliminar cliente"> </TD>
			</FORM>
			<input type="date" name="bday">
			<FORM action=" traerFactura.jsp ">
				<TD><INPUT type="submit" value="Traer Factura del cliente"> </TD>
			</FORM>
			
			<FORM action=" reporteConsumoPorCliente.jsp ">
				<TD><INPUT type="submit" value="Traer Factura del cliente"> </TD>
			</FORM>			
			<FORM action=" traerFacturasEntreFechas.jsp ">
				<TD><INPUT type="submit" value="Traer Facturas entre fechas"> </TD>
			</FORM>
			</TR>
		</TABLE>
	
</BODY>
</HTML>