package datos;

public class DetalleBaja {

	private int idDetalleBaja;
	private String detalleConceptos;
	private String unidad;
	private int desde;
	private int hasta;
	private double valor;
	private TarifaBaja tarifaBaja;
	
	public DetalleBaja() {}
	
	public DetalleBaja(String detalleConceptos,String unidad, int desde, int hasta, double valor, TarifaBaja tarifaBaja) {
		super();
		this.detalleConceptos = detalleConceptos;
		this.unidad = unidad;
		this.desde = desde;
		this.hasta = hasta;
		this.valor = valor;
		this.tarifaBaja = tarifaBaja;
	}

	
	public String getDetalleConceptos() {
		return detalleConceptos;
	}

	public void setDetalleConceptos(String detalleConceptos) {
		this.detalleConceptos = detalleConceptos;
	}

	public int getIdDetalleBaja() {
		return idDetalleBaja;
	}

	public void setIdDetalleBaja(int idDetalleAlta) {
		this.idDetalleBaja = idDetalleAlta;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public TarifaBaja getTarifaBaja() {
		return tarifaBaja;
	}

	public void setTarifaBaja(TarifaBaja tarifaBaja) {
		this.tarifaBaja = tarifaBaja;
	}

	@Override
	public String toString() {
		return "DetalleBaja [idDetalleBaja=" + idDetalleBaja + ", detalleConceptos=" + detalleConceptos + ", unidad="
				+ unidad + ", desde=" + desde + ", hasta=" + hasta + ", valor=" + valor + "TarifaBaja="+ tarifaBaja.getServicio()+"]";
	}

	

	
	
	
}
