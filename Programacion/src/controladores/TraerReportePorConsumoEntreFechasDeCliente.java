package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.PersonaFisica;
import datos.PersonaJuridica;
import funciones.Funciones;
import negocio.ClienteABM;
import negocio.FacturaABM;
import negocio.DatosPersonalesABM;

public class TraerReportePorConsumoEntreFechasDeCliente  extends HttpServlet  {
	
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
		
		PersonaFisica fisico = (PersonaFisica)clienteabm.traerPersonaFisicaYDatosPersonales(dni);
		PersonaJuridica juridico = clienteabm.traerPersonaJuridica(cuit);
		System.out.println(fisico);
		System.out.println(juridico);
		String fInicial = request.getParameter("tiempo1");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		LocalDate f = LocalDate.parse(fInicial, formatter);
		
		String fFinal = request.getParameter("tiempo2");
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/d/yyyy");
		LocalDate f2 = LocalDate.parse(fFinal, formatter2);
		
		FacturaABM fabm = FacturaABM.getInstancia();
		
			
		
		if(fisico != null) {
			String datosObtenidos = fabm.reporteEntreFechasConsumoCliente( fisico, f, f2);
			request.setAttribute("datosObtenidos", datosObtenidos);
			request.getRequestDispatcher("/mostrarReportePorConsumoDeClienteEntreFechas.jsp").forward(request, response);
		}
		if(juridico != null) {
			String datosObtenidos2 = fabm.reporteEntreFechasConsumoCliente( juridico, f, f2);
			request.setAttribute("datosObtenidos2", datosObtenidos2);
			request.getRequestDispatcher("/mostrarReportePorConsumoDeClienteEntreFechasJuridico.jsp").forward(request, response);
		}
		
		
		
	

	}
}
