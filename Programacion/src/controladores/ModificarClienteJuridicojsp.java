package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datos.PersonaJuridica;
import funciones.Funciones;
import negocio.ClienteABM;

public class ModificarClienteJuridicojsp extends HttpServlet{
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
		String cuit = request.getParameter("cuit");
		String razonSocial = request.getParameter("razon social");
		String direccion = request.getParameter("direccion");
		PersonaJuridica juridico = (PersonaJuridica)clienteabm.traerPersonaJuridica(cuit);
		juridico.setDireccion(direccion);
		juridico.setRazonSocial(razonSocial);
		clienteabm.actualizarCliente(juridico);
		request.getRequestDispatcher("cliente/modificar/clientemodificado.jsp").forward(request, response);

	}
}
