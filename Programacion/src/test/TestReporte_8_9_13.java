package test;

import java.time.LocalDate;

import datos.Factura;
import negocio.FacturaABM;

public class TestReporte_8_9_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FacturaABM abm = FacturaABM.getInstancia();
		try {
			System.out.println("Reporte 8");
			for(Factura f : abm.traerFacturasEntreFechas(LocalDate.of(2019, 01, 01), LocalDate.of(2019, 12, 31))) {
				System.out.println(f);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Reporte 9");
			System.out.println(abm.energiaTotalEntregadaEntreFechas(LocalDate.of(2019, 01, 01), LocalDate.of(2019, 12, 31)));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Reporte 13");
			System.out.println(abm.ConsumoTotalPorBandaTarifariaEntreFechas(LocalDate.of(2019, 01, 01), LocalDate.of(2019, 12, 31)));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
