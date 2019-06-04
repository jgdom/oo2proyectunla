package datos;

import java.time.LocalDate;
import java.util.Set;

public class Factura {
	
	private int idFactura;
	private int nroSerieMedidor; 	//el dato de medidor
	private int idCliente;			//el dato de cliente
	private LocalDate fecha;		//La fecha que se emitira la factura a pagar
	private String observaciones;	//Va la lectura anterior con la lectura ultima concatenada en una string
	private Set<ItemFactura> lstItemFactura;
	
	public Factura() {}

	public Factura(int nroSerieMedidor, int idCliente, LocalDate fecha, String observaciones) {
		super();
		this.nroSerieMedidor = nroSerieMedidor;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	public double CalcularTotalAPagar() {
		double TOTAL = 0;
		//	genero una instancia : Recorro la lista
		for ( ItemFactura IF : this.getLstItemFactura())
			TOTAL = TOTAL + IF.calcularSubTotal();
		
		return TOTAL;
	}
	
	/*
	public double CalcularTotalAPagar(LecturaAlta lectura) {
		double TOTAL = 0;
		//	genero una instancia : Recorro la lista
		for ( ItemFactura IF : this.getLstItemFactura())
			TOTAL = TOTAL + IF.calcularSubTotal();
		
		return TOTAL;
	}
	*/
	
	public LocalDate CalcularPrimerVencimiento() {
		LocalDate FechaVencimiento = fecha.plusDays(10);
			// despues de diez dias de haber emitido la factura a pagar, sera su primer vencimiento
		return 	FechaVencimiento;	
	}
	
	public LocalDate CalcularSegundoVencimiento() {
		LocalDate FechaVencimiento = fecha.plusDays(20); 
				// despues de veinte dias de haber emitido la factura a pagar, sera el segundo vencimiento	
		return 	FechaVencimiento;	
	}
	
	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getNroSerieMedidor() {
		return nroSerieMedidor;
	}

	public void setNroSerieMedidor(int nroSerieMedidor) {
		this.nroSerieMedidor = nroSerieMedidor;
	}

	public int getidCliente() {
		return idCliente;
	}

	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<ItemFactura> getLstItemFactura() {
		return lstItemFactura;
	}

	public void setLstItemFactura(Set<ItemFactura> lstItemFactura) {
		this.lstItemFactura = lstItemFactura;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", nroSerieMedidor=" + nroSerieMedidor + ", idCliente=" + idCliente
				+ ", fecha=" + fecha + ", observaciones=" + observaciones + "]";
	}
	
	
	
	
	
}
