package datos;

public class Zona {
	private int codZona;
	private String nombre;
	private int idZona;
	public Zona(int codZona, String nombre) {
		super();
		this.codZona = codZona;
		this.nombre = nombre;
	}
	protected int getCodZona() {
		return codZona;
	}
	public void setCodZona(int codZona) {
		this.codZona = codZona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// despues preguntar esto
	protected int getIdZona() {
		return idZona;
	}
	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}
	public Zona(int codZona, String nombre, int idZona) {
		super();
		this.codZona = codZona;
		this.nombre = nombre;
		this.idZona = idZona;
	}


	
}
