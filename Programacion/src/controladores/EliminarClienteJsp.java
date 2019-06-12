package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DatosPersonales;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import funciones.Funciones;
import negocio.ClienteABM;
import negocio.DatosPersonalesABM;

public class EliminarClienteJsp extends HttpServlet {
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

		String cuit = request.getParameter("cuit");
		int dni = 0;
		String guardadoDni = request.getParameter("dni");
		if (Funciones.esCadenaDeNumeros(guardadoDni)) {
			dni = Integer.parseInt(guardadoDni);
		}
		PersonaFisica fisico = clienteabm.traerPersonaFisica(dni);
		PersonaJuridica juridico = clienteabm.traerPersonaJuridica(cuit);
		if (fisico == null && juridico == null) {
			System.out.println("exception tire");
			response.sendError(500, "no existe el cliente");
		} else if(fisico!=null){
			try {
				DatosPersonales d = fisico.getdPersonales();
				clienteabm.eliminarCliente(fisico);
				DatosPersonalesABM dpabm = DatosPersonalesABM.getInstancia();
				dpabm.eliminarDatosPersonales(d);
			} catch (Exception e) {
				response.sendError(500, "ERROR ");
			}
		}else if(juridico!=null){
				try {
					clienteabm.eliminarCliente(juridico);
				} catch (Exception e) {
					response.sendError(500, "ERROR ");
				}
			}

		request.getRequestDispatcher("cliente/baja/clienteEliminado.jsp").forward(request, response);

	}
}