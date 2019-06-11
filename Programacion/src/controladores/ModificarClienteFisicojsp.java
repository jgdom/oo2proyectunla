package controladores;

import negocio.DatosPersonalesABM;
import datos.PersonaFisica;
import funciones.Funciones;
import datos.DatosPersonales;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ClienteABM;

import negocio.DatosPersonalesABM;

public class ModificarClienteFisicojsp extends HttpServlet {
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
		
		
		int dni = 0;
		String guardadoDni = request.getParameter("dni");
		if (Funciones.esCadenaDeNumeros(guardadoDni)) {
			dni = Integer.parseInt(guardadoDni);
		}

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		System.out.println(clienteabm.traerPersonaFisica(dni));
		System.out.println(clienteabm.traerPersonaFisicaYDatosPersonales(dni));
		PersonaFisica fisico = (PersonaFisica)clienteabm.traerPersonaFisica(dni);
		fisico.setDireccion(direccion);
		DatosPersonalesABM dabm = DatosPersonalesABM.getInstancia();
		DatosPersonales dp = dabm.traerDatosPersonalesPorDNI(dni);
		dp.setApellido(apellido);
		dp.setNombre(nombre);
		clienteabm.actualizarCliente(fisico);
		dabm.actualizar(dp);
		request.getRequestDispatcher("/cliente/modificar/clientemodificado.jsp").forward(request, response);

	}
}