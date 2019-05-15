package datos;

import java.util.Set;

public class Zona {
	private int idZona;
	private String nombre;
	private Set<Inspector> inspector;
	private Set<Medidor> medidor;
	public Zona() {}
	
	public Zona( String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getIdZona() {
		return idZona;
	}
	protected void setIdZona(int idZona) {
		this.idZona = idZona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Inspector> getInspector() {
		return inspector;
	}
	public void setInspector(Set<Inspector> inspector) {
		this.inspector = inspector;
	}
	@Override
	public String toString() {
		return "Zona [idZona=" + idZona + ", nombre=" + nombre + "]";
	}
	public boolean equals(Zona z) {
		return this.idZona == z.getIdZona();
	}

	public Set<Medidor> getMedidor() {
		return medidor;
	}

	public void setMedidor(Set<Medidor> medidor) {
		this.medidor = medidor;
	}
	
}
