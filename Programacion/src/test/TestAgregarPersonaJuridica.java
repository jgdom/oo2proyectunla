package test;

import datos.PersonaJuridica;
import negocio.ClienteABM;

public class TestAgregarPersonaJuridica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm =ClienteABM.getInstancia();
		try {
			
			PersonaJuridica j = new PersonaJuridica("1","personajuridica 1","1");
			System.out.println("Ultimo id agregado-->" + abm.agregarPersonaJuridica(j));
			PersonaJuridica j2 = new PersonaJuridica("2","personajuridica 2","2");
			System.out.println("Ultimo id agregado-->" + abm.agregarPersonaJuridica(j2));
			PersonaJuridica j3 = new PersonaJuridica("3","personajuridica 3","3");
			System.out.println("Ultimo id agregado-->" + abm.agregarPersonaJuridica(j3));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			PersonaJuridica j1 = abm.traerPersonaJuridica("1");
			System.out.println(j1);
			PersonaJuridica j2 = abm.traerPersonaJuridica("2");
			System.out.println(j2);
			PersonaJuridica j3 = abm.traerPersonaJuridica("3");
			System.out.println(j3);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
