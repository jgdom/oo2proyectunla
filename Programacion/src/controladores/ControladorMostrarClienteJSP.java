package controladores;
import negocio.DatosPersonalesABM;
import datos.DatosPersonales;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ClienteABM;
import datos.Cliente;
import datos.PersonaFisica;
import datos.PersonaFisica;
public class ControladorMostrarClienteJSP extends HttpServlet {
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
			ClienteABM clienteabm = ClienteABM.getInstancia();
			
			Cliente cliente = clienteabm.traerPersonaFisicaYDatosPersonales(dni);
			request.setAttribute("datos",  cliente);
			request.getRequestDispatcher("/vistacliente.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "El DNI Ingresado no existe en la base de datos.");
		}
	}
}