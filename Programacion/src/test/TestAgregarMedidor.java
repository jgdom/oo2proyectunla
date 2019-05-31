package test;

import negocio.MedidorABM;
import datos.Medidor;
import datos.Zona;
import datos.Tarifa;
import datos.PersonaJuridica;
import negocio.ZonaABM;
import negocio.TarifaABM;
import negocio.ClienteABM;

public class TestAgregarMedidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedidorABM dao = MedidorABM.getInstancia();
		ZonaABM zabm = ZonaABM.getInstacia();
		TarifaABM tamb = TarifaABM.getInstancia();
		ClienteABM cabm = ClienteABM.getInstancia();
		
		try {
			Zona z = zabm.traerZona(1);
			System.out.println(z);
			Tarifa t = tamb.traerTarifa(2);
			System.out.println(t);
			PersonaJuridica c = cabm.traerPersonaJuridica("1");
			System.out.println(c);
			String direccion = c.getDireccion();
			System.out.println(direccion);
			Medidor m = new Medidor(direccion,z,t,c);
			System.out.println(m);
			System.out.println("Ultimo id agregado-->" + dao.agregarMedidor(m));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
