package test;

import java.time.LocalDate;

import dao.HibernateUtil;
import datos.Factura;
import negocio.FacturaABM;


public class TestAgregarFacturaYItemFactura {

	public static void main(String[] args) {
		
		FacturaABM FABM = FacturaABM.getInstancia();
		
		//-------------------------------------------------------------Ahora agrego la factura
		try {
			LocalDate LD = LocalDate.of(2019, 05, 31);
			
			Factura F = FABM.traerFactura(FABM.agregarFactura(1, 1, LD, "Algo"));
			System.out.println(F.getIdFactura());
			
			//Agrego los Item de Factura, que seran dos.
			//ItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura)
			System.out.println(FABM.agregarItemFactura("Bajo Consumo", 32.82, 140, "$/mes", F));
			
			System.out.println(FABM.agregarItemFactura("Bajo Consumo", 32.82, 100, "$/mes", F));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
            LocalDate fecha = LocalDate.of(2019, 05, 31);
            System.out.println("aca toy");
            Factura f = FABM.traerFacturaConItemFactura(1, fecha);
            System.out.println(f);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
		
		HibernateUtil.getSessionFactory().close();
	}

}
