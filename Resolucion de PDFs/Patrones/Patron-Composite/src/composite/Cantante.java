package composite;

public class Cantante extends IntegranteComponente {
	public Cantante(String nombre) {
		super(nombre);
	}

	@Override
	public String usarInstrumento() {
		return "\nCantante: " + nombre;
	}
}
