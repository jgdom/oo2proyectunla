package composite;

public class Guitarrista extends IntegranteComponente {
	public Guitarrista(String nombre) {
		super(nombre);
	}

	@Override
	public String usarInstrumento() {
		return "\nGuitarra: " + nombre;
	}
}