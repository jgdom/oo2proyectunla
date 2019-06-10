package controladores;
import negocio.DatosPersonalesABM;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import datos.Cliente;
import funciones.Funciones;
import datos.DatosPersonales;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.ClienteABM;
import datos.PersonaFisica;

public class TraerClienteFisico extends HttpServlet {
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
		ClienteABM clienteabm = ClienteABM.getInstancia();
		String direccionPedido = request.getHeader("referer").replaceAll("(.+?(?=Programacion))|(\\?(.*))", "");
		int dni = Integer.parseInt( request.getParameter("dni"));
		ClienteABM cabm = ClienteABM.getInstancia();
		PersonaFisica cliente = (PersonaFisica) cabm.traerPersonaFisicaYDatosPersonales(dni);
		request.setAttribute("cliente", cliente);
		if(direccionPedido.equalsIgnoreCase("Programacion/busquedaDni.jsp")) {
			request.getRequestDispatcher("/MostrarClienteFisico.jsp").forward(request, response);
		}
		else if(direccionPedido.equals("Programacion/BusquedaEliminarFisico.jsp")){
			request.getRequestDispatcher("/MostrarClienteFisicoEliminar.jsp").forward(request, response);
		}

	}
}