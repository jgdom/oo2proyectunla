package datos;

public class FacturaPersisitente {
	private int idFacturaPersistente;

	public FacturaPersisitente(int idFacturaPersistente) {
		super();
		this.idFacturaPersistente = idFacturaPersistente;
	}

	public int getIdFacturaPersistente() {
		return idFacturaPersistente;
	}

	protected void setIdFacturaPersistente(int idFacturaPersistente) {
		this.idFacturaPersistente = idFacturaPersistente;
	}

	@Override
	public String toString() {
		return "FacturaPersisitente [idFacturaPersistente=" + idFacturaPersistente + "]";
	}
	

}
