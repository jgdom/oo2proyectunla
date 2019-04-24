package test;

import java.util.GregorianCalendar;
import datos.Boleto;
import datos.Cliente;
import datos.Funcion;

public class Test {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("Siciliano", "Gustavo Hernan");
		Funcion funcion = new Funcion("La teor�a del todo", new GregorianCalendar(5, 2, 2018));
		
		Boleto boleto10 = funcion.verBoleto(10);
		boleto10.reservarButaca(cliente);
		boleto10.confirmar();
		
		Boleto boleto11 = funcion.verBoleto(11);
		boleto11.reservarButaca(cliente);
		boleto11.cancelarCompra();
		
		Boleto boleto12 = funcion.verBoleto(12);
		
		boleto12.confirmar(); // Qu� pasa?
		boleto12.cancelarCompra(); // Qu� pasa?
		boleto12.reservarButaca(cliente); // Qu� pasa?
		boleto12.reservarButaca(cliente); // Qu� pasa?
		boleto12.cancelarCompra(); // Qu� pasa?
	}
}
