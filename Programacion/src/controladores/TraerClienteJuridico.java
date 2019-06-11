package controladores;

import datos.PersonaJuridica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ClienteABM;

public class TraerClienteJuridico extends HttpServlet {
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
		String cuit = request.getParameter("cuit");
		ClienteABM cabm = ClienteABM.getInstancia();
		PersonaJuridica cliente = cabm.traerPersonaJuridica(cuit);
		request.setAttribute("cliente", cliente);
		if (direccionPedido.equals("Programacion/cliente/modificar/busquedaCuit.jsp")) {
			request.getRequestDispatcher("cliente/modificar/mostrarClienteJuridico.jsp").forward(request, response);
		}else if(direccionPedido.equals("Programacion/cliente/baja/busquedaCuit.jsp")) {
			request.getRequestDispatcher("cliente/baja/mostrarClienteJuridico.jsp").forward(request, response);
		}

	}
}