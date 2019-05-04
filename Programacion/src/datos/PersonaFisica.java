package datos;

public class PersonaFisica extends Cliente{
	private String razonSocial;
	private String cuit;
	public PersonaFisica(int idCliente, String direccion, String razonSocial, String cuit) {
		super(idCliente, direccion);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	@Override
	public String toString() {
		return "PersonaFisica [razonSocial=" + razonSocial + ", cuit=" + cuit + "]";
	}
	
}
