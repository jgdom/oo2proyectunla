package datos;

public class DetalleAlta {

	private int idDetalleAlta;
	private String detalleConceptos;
	private String unidad;
	private boolean superaLimite;
	private double valor;
	private TarifaAlta tarifaAlta;
	
	public DetalleAlta() {}

	public DetalleAlta(String detalleConceptos, String unidad, boolean superaLimite, double valor, TarifaAlta tarifaAlta) {
		super();
		this.detalleConceptos = detalleConceptos;
		this.unidad = unidad;
		this.superaLimite = superaLimite;
		this.valor = valor;
		this.tarifaAlta = tarifaAlta;
	}

	public int getIdDetalleAlta() {
		return idDetalleAlta;
	}

	public void setIdDetalleAlta(int idDetalleAlta) {
		this.idDetalleAlta = idDetalleAlta;
	}

	public String getDetalleConceptos() {
		return detalleConceptos;
	}

	public void setDetalleConceptos(String detalleConceptos) {
		this.detalleConceptos = detalleConceptos;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public boolean isSuperaLimite() {
		return superaLimite;
	}

	public void setSuperaLimite(boolean superaLimite) {
		this.superaLimite = superaLimite;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public TarifaAlta getTarifaAlta() {
		return tarifaAlta;
	}

	public void setTarifaAlta(TarifaAlta tarifaAlta) {
		this.tarifaAlta = tarifaAlta;
	}

	@Override
	public String toString() {
		return "DetalleAlta [idDetalleAlta=" + idDetalleAlta + ", detalleConceptos=" + detalleConceptos + ", unidad="
				+ unidad + ", superaLimite=" + superaLimite + ", valor=" + valor + "TarifaAlta="+tarifaAlta.getServicio()+"]";
	}
	

	
	
	
	
}
