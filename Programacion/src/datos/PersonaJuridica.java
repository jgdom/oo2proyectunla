package datos;

public class PersonaJuridica extends Cliente {
	private DatosPersonales dPersonales;

	public PersonaJuridica(int idCliente, String direccion, DatosPersonales dPersonales) {
		super(idCliente, direccion);
		this.dPersonales = dPersonales;
	}

	public DatosPersonales getdPersonales() {
		return dPersonales;
	}

	public void setdPersonales(DatosPersonales dPersonales) {
		this.dPersonales = dPersonales;
	}

	@Override
	public String toString() {
		return "PersonaJuridica [dPersonales=" + dPersonales + "]";
	}
	

}
