package controladores;

import negocio.DatosPersonalesABM;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import funciones.Funciones;
import datos.DatosPersonales;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ClienteABM;
import datos.PersonaJuridica;
import dao.ClienteDao;

import negocio.DatosPersonalesABM;

public class AltaClienteJsp extends HttpServlet {
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
		String direccion = request.getParameter("direccion");
		int dni = 0;
		String guardadoDni = request.getParameter("dni");
		if (Funciones.esCadenaDeNumeros(guardadoDni)) {
			dni = Integer.parseInt(guardadoDni);
		}
		
		
		System.out.println(dni);
		System.out.println(direccion);
		System.out.println(cuit);
		PersonaFisica fisico = clienteabm.traerPersonaFisica(dni);
		PersonaJuridica juridico = clienteabm.traerPersonaJuridica(cuit);
		System.out.println(fisico);
		if (fisico != null || juridico != null) {
			System.out.println("exception tire");
			response.sendError(500, "ya existe en la bd");
		} else if ((fisico == null && dni > 0) && juridico == null) {
			System.out.println("aca entre");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");

			DatosPersonalesABM dt = DatosPersonalesABM.getInstancia();
			DatosPersonales d = new DatosPersonales(nombre, apellido, dni);
			PersonaFisica pf = new PersonaFisica(direccion, d);

			try {
				dt.agregarDatosPersonales(d);
				clienteabm.agregarPersonaFisica(pf);

			} catch (Exception e) {
				response.sendError(500, "ERROR ");
			}
		}

		else if ((cuit.length() > 0 && juridico == null) && fisico	 == null) {
			String razonSocial = request.getParameter("razonsocial");
			PersonaJuridica pj = new PersonaJuridica(direccion, razonSocial, cuit);
			try {
				clienteabm.agregarPersonaJuridica(pj);
			} catch (Exception e) {
				response.sendError(500, "ERROR ");
			}
		}

		request.getRequestDispatcher("/vistacliente.jsp").forward(request, response);

	}
}