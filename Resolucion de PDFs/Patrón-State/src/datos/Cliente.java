package datos;

public class Cliente {
	private int idCliente;
	private String apellido;
	private String nombre;

	public Cliente(String apellido, String nombre) {
		this.apellido = apellido;
		this.nombre = nombre;
	}

	/*---------- GETs Y SETs ----------*/
	public int getIdCliente() {
		return idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
