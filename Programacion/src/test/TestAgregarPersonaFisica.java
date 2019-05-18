package test;

import datos.Cliente;
import datos.PersonaFisica;
import datos.DatosPersonales;
import negocio.ClienteABM;
import negocio.DatosPersonalesABM;


public abstract class TestAgregarPersonaFisica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmc = ClienteABM.getInstancia();
		DatosPersonalesABM abmp = DatosPersonalesABM.getInstancia();
		try {
			DatosPersonales p = abmp.traerDatosPersonalesPorDNI(2);
			System.out.println(p);
			PersonaFisica f = new PersonaFisica("Calle 1",p);
			System.out.println("Ultimo id agregado-->" + abmc.agregarPersonaFisica(f));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Cliente c = abmc.traerCliente(9);
			System.out.println(c);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
		PersonaFisica c = abmc.traerPersonaFisica(2);
			System.out.println(c);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
