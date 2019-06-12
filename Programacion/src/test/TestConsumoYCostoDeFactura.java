package test;

import datos.Factura;
import negocio.FacturaABM;
import negocio.Funciones;

public class TestConsumoYCostoDeFactura {

	public static void main(String[] args) {
		FacturaABM FABM = FacturaABM.getInstancia();
		
		Factura factura = FABM.traerFacturaConItemFactura(1, Funciones.traerFecha(03, 05, 2019));

		System.out.println("Consumo total: "+FABM.ConsumoTotalFactura(factura));
		
		System.out.println("Costo total: "+FABM.CostoTotalFactura(factura));
		
	}

}
