package controladores;
import datos.ItemFactura;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Factura;
import negocio.FacturaABM;

public class TraerFacturasEntreFechas extends HttpServlet {

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

		String fInicial = request.getParameter("tiempo1");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		LocalDate f = LocalDate.parse(fInicial, formatter);

		String fFinal = request.getParameter("tiempo2");

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/d/yyyy");
		LocalDate f2 = LocalDate.parse(fFinal, formatter2);

		FacturaABM fabm = FacturaABM.getInstancia();
		List<Factura> factura = new ArrayList<Factura>();
		factura = fabm.traerFacturasEntreFechas(f, f2);
		
		List<ItemFactura> lista = new ArrayList<ItemFactura>();
		for(int i = 0; i < factura.size(); i++) {
				
		for (ItemFactura a: factura.get(i).getLstItemFactura()) {
			lista.add(a);
		}
		}
		
		request.setAttribute("factura", factura);
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("/mostrarFacturaEntreFechas.jsp").forward(request, response);

	}
}
