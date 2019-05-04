package datos;

import java.util.Set;

public class Inspector {
	private int idInspector;
	// 
	private Set<Lectura> lectura;
	//
	private DatosPersonales dPersonales;
	private Set<Zona> zonas;
	public Inspector(int idInspector, Set<Lectura> lectura, DatosPersonales dPersonales, Set<Zona> zonas) {
		super();
		this.idInspector = idInspector;
		this.lectura = lectura;
		this.dPersonales = dPersonales;
		this.zonas = zonas;
	}
	protected int getIdInspector() {
		return idInspector;
	}
	public void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}
	public Set<Lectura> getLectura() {
		return lectura;
	}
	public void setLectura(Set<Lectura> lectura) {
		this.lectura = lectura;
	}
	public DatosPersonales getdPersonales() {
		return dPersonales;
	}
	public void setdPersonales(DatosPersonales dPersonales) {
		this.dPersonales = dPersonales;
	}
	public Set<Zona> getZonas() {
		return zonas;
	}
	public void setZonas(Set<Zona> zonas) {
		this.zonas = zonas;
	}
	
}
