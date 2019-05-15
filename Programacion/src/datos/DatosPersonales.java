package datos;

public class DatosPersonales {
	
	private int idDatosPersonales;
	private String nombre;
	private String apellido;
	private int dni;
	private PersonaFisica personafisica;
	private Inspector inspector;
	public DatosPersonales() {}
	
	public DatosPersonales(String nombre, String apellido, int dni,Inspector inspector) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.inspector = inspector;
	}
	
	public DatosPersonales(String nombre, String apellido, int dni,PersonaFisica cliente) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.personafisica = cliente;
	}
	
	public DatosPersonales(String nombre, String apellido, int dni) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}


	public int getIdDatosPersonales() {
		return idDatosPersonales;
	}

	protected void setIdDatosPersonales(int idDatosPersonales) {
		this.idDatosPersonales = idDatosPersonales;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "DatosPersonales [idDatosPersonales=" + idDatosPersonales + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + "]";
	}




	public PersonaFisica getPersonafisica() {
		return personafisica;
	}

	public void setPersonafisica(PersonaFisica personafisica) {
		this.personafisica = personafisica;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

    // para probar zonas e inspectores fue.
	
	

	
	

}
