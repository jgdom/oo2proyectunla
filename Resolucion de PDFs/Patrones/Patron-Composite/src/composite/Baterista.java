package composite;

public class Baterista extends IntegranteComponente {
	public Baterista(String nombre) {
		super(nombre);
	}

	@Override
	public String usarInstrumento() {
		return "\nBatería: " + nombre;
	}
}
