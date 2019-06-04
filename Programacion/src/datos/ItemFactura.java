package datos;

public class ItemFactura {

	private int idItemFactura;
	private String detalle; 	
	private double precioUnitario;
	private int cantidad;			//TENDRIA QUE SER DOUBLE
	private String unidad;
	private Factura factura;
	
	public ItemFactura() {}

	public ItemFactura(String detalle, double precioUnitario, int cantidad, String unidad, Factura factura) {
		super();
		this.detalle = detalle;					//Si el consumo es Bajo o Alto
		this.precioUnitario = precioUnitario;	//Es el precio por KWH de su tarifa correspondientemente si supero los limites o no
		this.cantidad = cantidad;				//es la suma entre lecturaBaja/Alta anterior y lecturaBaja/Alta ultima ---- Consumo total
		this.unidad = unidad;					//$
		this.factura = factura;
	}

	public double calcularSubTotal() {  //se llama desde el JSP de la parte de la vista
		return (precioUnitario*cantidad);
	}
	
	public int getIdItemFactura() {
		return idItemFactura;
	}

	public void setIdItemFactura(int idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "ItemFactura [idItemFactura=" + idItemFactura + ", detalle=" + detalle + ", precioUnitario="
				+ precioUnitario + ", cantidad=" + cantidad + ", unidad=" + unidad + ", factura=" + factura + "]";
	}
	
	
	
}
