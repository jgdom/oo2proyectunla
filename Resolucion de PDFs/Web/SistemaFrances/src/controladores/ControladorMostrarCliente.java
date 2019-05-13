package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.Cliente;
import negocio.ClienteABM;

public class ControladorMostrarCliente extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));
			ClienteABM clienteAbm = new ClienteABM();
			Cliente cliente = clienteAbm.traerCliente(dni);
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println("");
			salida.println("<!DOCTYPE 4.01 Transitional//EN\">");
			salida.println("<HTML>");
			salida.println(" <HEAD>");
			salida.println(" <TITLE>Sistema Franc�s</TITLE>");
			salida.println(" </HEAD>");
			salida.println(" <BODY>");
			salida.println(" Apellido: " + cliente.getApellido() + "<BR>");
			salida.println(" Nombre : " + cliente.getNombre() + "<BR>");
			salida.println(" DNI : " + cliente.getDni() + "<BR>");
			salida.println(" ID : " + cliente.getIdCliente() + "<BR>");
			salida.println("<A href=\"/SistemaFrances/cliente.html\">Volver...</A>");
			salida.println(" </BODY>");
			salida.println("</HTML>");
		} catch (Exception e) {
			response.sendError(500, "El DNI Ingresado no existe en la base de datos.");
		}
	}
}