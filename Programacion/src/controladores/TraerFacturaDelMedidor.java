
package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import negocio.FacturaABM;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Medidor;
import negocio.MedidorABM;
import datos.PersonaJuridica;
import negocio.ClienteABM;
import datos.Cliente;
import datos.Factura;
public class TraerFacturaDelMedidor   extends HttpServlet {
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
		FacturaABM fabm = FacturaABM.getInstancia();
		MedidorABM mabm = MedidorABM.getInstancia();
		Medidor m = new Medidor();
		int nroMedidor = Integer.parseInt(request.getParameter("nroMedidor"));
		m = mabm.TreaerMedidor((long) nroMedidor);
		String fecha = request.getParameter("datepicker");
		System.out.println(fecha);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		LocalDate f = LocalDate.parse(fecha, formatter);
		System.out.println(fecha);
		Factura factura = new Factura();
		factura = fabm.generarFacturaWeb(m, f);
		//traigo Cliente
		//factura.getidCliente();
		ClienteABM cabm = ClienteABM.getInstancia();
		double CostoTotal = fabm.CostoTotalFactura(factura);
		request.setAttribute("CostoTotal", CostoTotal);
		Cliente cliente = cabm.traerCliente(factura.getidCliente());
		String mostrar = cliente.getDireccion();
		request.setAttribute("factura", factura);
		request.setAttribute("mostrar", mostrar);
		request.getRequestDispatcher("MostrarFactura.jsp").forward(request, response);
}
}