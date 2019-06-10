package test;


import negocio.FacturaABM;

public class ReporteOnce {

	public static void main(String[] args) {
		
		FacturaABM FABM = FacturaABM.getInstancia();

		System.out.println(FABM.reporteClienteMayorConsumoHoraPico());
	}

}
