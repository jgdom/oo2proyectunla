package datos;

public class DatosPersonales {
	private String nombre;
	private String apellido;
	private int dni;
	public DatosPersonales(String nombre, String apellido, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	protected int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "DatosPersonales [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	
}
