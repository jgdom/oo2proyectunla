package datos;

import java.time.LocalDate;

public class Factura {
	private int idFactura;
	private Tarifa tarifa;
	private LocalDate fecha;
	private Lectura lecturaAnterior;
	private Lectura lecturaUltima;
	public Factura(int idFactura, Tarifa tarifa, LocalDate fecha, Lectura lecturaAnterior, Lectura lecturaUltima) {
		super();
		this.idFactura = idFactura;
		this.tarifa = tarifa;
		this.fecha = fecha;
		this.lecturaAnterior = lecturaAnterior;
		this.lecturaUltima = lecturaUltima;
	}
	public int getIdFactura() {
		return idFactura;
	}
	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Lectura getLecturaAnterior() {
		return lecturaAnterior;
	}
	public void setLecturaAnterior(Lectura lecturaAnterior) {
		this.lecturaAnterior = lecturaAnterior;
	}
	public Lectura getLecturaUltima() {
		return lecturaUltima;
	}
	public void setLecturaUltima(Lectura lecturaUltima) {
		this.lecturaUltima = lecturaUltima;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", tarifa=" + tarifa + ", fecha=" + fecha + ", lecturaAnterior="
				+ lecturaAnterior + ", lecturaUltima=" + lecturaUltima + "]";
	}
	
}
