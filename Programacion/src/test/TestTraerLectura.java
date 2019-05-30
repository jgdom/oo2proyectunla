package test;

import java.util.List;
import datos.Lectura;
import datos.Medidor;
import negocio.LecturaABM;
import negocio.MedidorABM;

public class TestTraerLectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LecturaABM abm = LecturaABM.getInstaciaABM();
		MedidorABM abmm = MedidorABM.getInstancia();
		try {
			Medidor m = abmm.traerMedidor(1);
			List<Lectura> lista = abm.traerLecturaYMedidor(m.getNroSerie());
			for(int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			Medidor m = abmm.traerMedidor(1);
		    System.out.println(abm.traerLectura(m, 05, 2019));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		

	}

}
