package datos;

public class PersonaFisica extends Cliente{
	
	private int idPersonaFisica;
	private DatosPersonales dPersonales;
	
	public PersonaFisica() {}

	public PersonaFisica(String direccion, DatosPersonales dPersonales) {
		super(direccion);
		this.dPersonales = dPersonales;
	}

	public int getIdPersonaFisica() {
		return idPersonaFisica;
	}

	protected void setIdPersonaFisica(int idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
	}

	public DatosPersonales getdPersonales() {
		return dPersonales;
	}

	public void setdPersonales(DatosPersonales dPersonales) {
		this.dPersonales = dPersonales;
	}

	@Override
	public String toString() {
		return super.toString() + "PersonaFisica [idPersonaFisica=" + idPersonaFisica + "]" + " Nombre: " + dPersonales.getNombre() + " Apellido: " + dPersonales.getApellido() + " DNI: " + dPersonales.getDni();
	}

	
	
	

}
