package composite;

public abstract class IntegranteComponente {
	protected String nombre;

	public IntegranteComponente(String nombre) {
		this.nombre = nombre;
	}

	protected abstract String usarInstrumento();
}
