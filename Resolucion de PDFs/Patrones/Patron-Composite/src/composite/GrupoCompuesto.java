package composite;

import java.util.ArrayList;
import java.util.List;

public class GrupoCompuesto extends IntegranteComponente {
	private List<IntegranteComponente> lstIntegranteComponente;

	/*---------- Constructor ----------*/
	public GrupoCompuesto(String nombre) {
		super(nombre);
		this.setLstIntegranteComponente(new ArrayList<IntegranteComponente>());
	}

	/*---------- Methods ----------*/
	@Override
	public String usarInstrumento() {
		String cancion = "\nGrupoCompuesto: " + nombre;
		for (IntegranteComponente integrante : this.getLstIntegranteComponente()) {
			cancion = cancion.concat(integrante.usarInstrumento().concat(" "));
		}
		return cancion;
	}

	public void addIntegranteComponente(IntegranteComponente integrante) {
		this.getLstIntegranteComponente().add(integrante);
	}

	public void removeIntegranteComponente(IntegranteComponente integrante) {
		this.getLstIntegranteComponente().remove(integrante);
	}

	public List<IntegranteComponente> getLstIntegranteComponente() {
		return lstIntegranteComponente;
	}

	public void setLstIntegranteComponente(List<IntegranteComponente> lstIntegranteComponente) {
		this.lstIntegranteComponente = lstIntegranteComponente;
	}
}
