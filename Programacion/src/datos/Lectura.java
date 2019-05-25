package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lectura {//hacerlo abstracto
	
	protected int idLectura;
	protected LocalTime hora;
	protected LocalDate fecha;
	protected Inspector inspector;
	protected Medidor medidor;
	
	public Lectura() {}
	
	public Lectura(LocalTime hora, LocalDate fecha,Inspector inspector,Medidor medidor) {
		super();
		this.hora = hora;
		this.fecha = fecha;
		this.inspector = inspector;
		this.medidor = medidor;
	}
	
	public int getIdLectura() {
		return idLectura;
	}
	
	protected void setIdLectura(int idLectura) {
		this.idLectura = idLectura;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Inspector getInspector() {
		return inspector;
	}
	
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	
	public Medidor getMedidor() {
		return medidor;
	}
	
	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}
	
	@Override
	public String toString() {
		return "Lectura [idLectura=" + idLectura + ", hora=" + hora + ", fecha=" + fecha + "]";
	}
	
	
}
