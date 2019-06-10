package test;

import negocio.FacturaABM;
import datos.Cliente;

public class TestReporte_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FacturaABM abm = FacturaABM.getInstancia();
		try {
			for(Cliente c : abm.traerClientesConMayorConsumo()) {
				System.out.println(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
