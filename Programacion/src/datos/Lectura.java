package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class Lectura {
	protected int idLectura;
	protected LocalTime hora;
	protected LocalDate fecha;
	protected Set<Inspector> inspector;
	protected Set<Medidor> medidor;
	public Lectura() {}
	public Lectura(LocalTime hora, LocalDate fecha) {
		super();
		this.hora = hora;
		this.fecha = fecha;
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
	public Set<Inspector> getInspector() {
		return inspector;
	}
	public void setInspector(Set<Inspector> inspector) {
		this.inspector = inspector;
	}
	public Set<Medidor> getMedidor() {
		return medidor;
	}
	public void setMedidor(Set<Medidor> medidor) {
		this.medidor = medidor;
	}
	
}
