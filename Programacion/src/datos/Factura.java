package datos;

import java.time.LocalDate;
import java.util.Set;

public class Factura {
	
	private int idFactura;
	private int nroSerieMedidor;
	private int idCliente;
	private LocalDate fecha;
	private String observaciones;
	private Set<ItemFactura> lstItemFactura;
	
	public Factura() {}

	public Factura(int nroSerieMedidor, int idCliente, LocalDate fecha, String observaciones) {
		super();
		this.nroSerieMedidor = nroSerieMedidor;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.observaciones = observaciones;
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
