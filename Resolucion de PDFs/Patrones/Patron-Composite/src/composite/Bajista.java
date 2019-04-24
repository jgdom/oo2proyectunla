package composite;

public class Bajista extends IntegranteComponente {
	public Bajista(String nombre) {
		super(nombre);
	}

	@Override
	public String usarInstrumento() {
		return "\nBajo: " + nombre;
	}
}
