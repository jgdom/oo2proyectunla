package test;


import dao.TarifaDao;
import datos.Cliente;
import datos.DatosPersonales;
import datos.Inspector;
import datos.Medidor;
import datos.PersonaFisica;
import datos.PersonaJuridica;
import datos.Tarifa;
import datos.Zona;
import negocio.ClienteABM;
import negocio.DatosPersonalesABM;
import negocio.DetallesTarifaABM;
import negocio.InspectorABM;
import negocio.MedidorABM;
import negocio.TarifaABM;
import negocio.ZonaABM;

public class TestCompleto {

	public static void main(String[] args) {
		
		DatosPersonalesABM abm = DatosPersonalesABM.getInstancia();
		ClienteABM clienteABM = ClienteABM.getInstancia();
		InspectorABM inspectorABM = InspectorABM.getInstancia();
		ZonaABM zabm = ZonaABM.getInstacia();
		TarifaABM tarifaABM = TarifaABM.getInstancia();
		MedidorABM medidorABM = MedidorABM.getInstancia();
		DetallesTarifaABM DTABM = DetallesTarifaABM.getInstancia();
		
		//--------------------------------------------------------------------- Agrego Una persona Fisica
		DatosPersonales DP = new DatosPersonales("Quimey","Perez",41237009);
		PersonaFisica PF = new PersonaFisica("9 de basto 3000", DP);
		try {
			System.out.println(abm.agregarDatosPersonales(DP));
			System.out.println(clienteABM.agregarPersonaFisica(PF));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		//--------------------------------------------------------------------- Agrego inspector
				
		DatosPersonales DP2 = new DatosPersonales("Juan","Domingez",42347332);
		Inspector inspector1 = new Inspector(DP2,"20-42347332-1");
		try {
			System.out.println(abm.agregarDatosPersonales(DP2));
			System.out.println(inspectorABM.agregarInspector(inspector1));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//---------------------------------------------------------------------- Agrego una Zona (Lanús)
		
		Zona z = new Zona("Lanús");
		try {
			System.out.println(zabm.agregarZona(z));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//---------------------------------------------------------------------- Agregar Tarifa de Cliente Quimey
			
		try {
			tarifaABM.agregarTarifaBaja("T1 - R1");
			DTABM.agregarDetalleBaja("Cargo Fijo", "$/mes", 0, 150, 32.82, tarifaABM.traerTarifaBaja("T1 - R1"));
			DTABM.agregarDetalleBaja("Cargo Variable", "$/kWh", 0, 150, 2.653, tarifaABM.traerTarifaBaja("T1 - R1"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//---------------------------------------------------------------------- Agregar Medidor de Cliente Quimey
		//Medidor(String direccion, Zona zona,Tarifa tarifa,Cliente cliente)

		try {
			Tarifa T = tarifaABM.traerTarifaBaja("T1 - R1"); //Traigo una tarifa, en este caso por ser fisico corresponde a la baja
			Medidor medidor1 = new Medidor(PF.getDireccion(), z, T, PF ); 
			System.out.println(medidorABM.agregarMedidor(medidor1));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		//---------------------------------------------------------------------- Agregar lectura  de medidor
		
		
		
		//---------------------------------------------------------------------- Agregar Facturas
		
		
		
		
		
	}

}
