package test;

import datos.LecturaBajaDemanda;
import datos.PersonaFisica;
import negocio.ClienteABM;
import negocio.FacturaABM;
import negocio.Funciones;
import negocio.InspectorABM;
import negocio.LecturaABM;
import negocio.MedidorABM;


public class ReporteSiete {

	public static void main(String[] args) {
		

		ClienteABM clienteABM = ClienteABM.getInstancia();
		InspectorABM inspectorABM = InspectorABM.getInstancia();
		MedidorABM medidorABM = MedidorABM.getInstancia();
		LecturaABM LABM = LecturaABM.getInstaciaABM();
		FacturaABM FABM = FacturaABM.getInstancia();

		PersonaFisica PF = clienteABM.traerPersonaFisica(31237009);
		
		
		LecturaBajaDemanda L3 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
				Funciones.traerFecha("03/06/2019"), inspectorABM.traerInspectorDni(42347332),
				medidorABM.traerMedidor(PF.getDireccion()), 100.0);

		LecturaBajaDemanda L4 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
				Funciones.traerFecha(3, 8, 2019), inspectorABM.traerInspectorDni(42347332),
				medidorABM.traerMedidor(PF.getDireccion()), 75.0);
		
		LecturaBajaDemanda L5 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
				Funciones.traerFecha("03/10/2019"), inspectorABM.traerInspectorDni(42347332),
				medidorABM.traerMedidor(PF.getDireccion()), 100.0);

		LecturaBajaDemanda L6 = new LecturaBajaDemanda(Funciones.traerTiempo(15, 0, 0),
				Funciones.traerFecha(3, 12, 2019), inspectorABM.traerInspectorDni(42347332),
				medidorABM.traerMedidor(PF.getDireccion()), 75.0);
		
		try {
			System.out.println(LABM.agregarLectura(L3));
			System.out.println(LABM.agregarLectura(L4));
			System.out.println(LABM.agregarLectura(L5));
			System.out.println(LABM.agregarLectura(L6));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("\n \n"+
					FABM.generarFactura(medidorABM.traerMedidor(PF.getDireccion()), Funciones.traerFecha(3, 9, 2019)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		try {
			System.out.println("\n \n"+
					FABM.generarFactura(medidorABM.traerMedidor(PF.getDireccion()), Funciones.traerFecha(6, 1, 2020)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println(FABM.reporteEntreFechasConsumoCliente(clienteABM.traerPersonaFisica(31237009), Funciones.traerFecha(1, 6, 2019), Funciones.traerFecha(1, 6, 2020)));
	}

}
