package datos;

import java.util.Set;

public class TarifaAlta extends Tarifa {
	
	private int idTarifaAlta;
	private String tensionContratada;
	private int limite;
	private Set<DetalleAlta> listDetalleAlta;
	
	public TarifaAlta() {}

	public TarifaAlta(String servicio, String tensionContratada, int limite) {
		super(servicio);
		this.tensionContratada = tensionContratada;
		this.limite = limite;
	}

	public int getIdTarifaAlta() {
		return idTarifaAlta;
	}


	public void setIdTarifaAlta(int idTarifaAlta) {
		this.idTarifaAlta = idTarifaAlta;
	}


	public String getTensionContratada() {
		return tensionContratada;
	}


	public void setTensionContratada(String tensionContratada) {
		this.tensionContratada = tensionContratada;
	}


	public int getLimite() {
		return limite;
	}


	public void setLimite(int limite) {
		this.limite = limite;
	}


	public Set<DetalleAlta> getListDetalleAlta() {
		return listDetalleAlta;
	}

	public void setListDetalle(Set<DetalleAlta> listDetalleAlta) {
		this.listDetalleAlta = listDetalleAlta;
	}
	
	
	public void agregarDetalleAlta(DetalleAlta DA) {
		listDetalleAlta.add(DA);
	}
	

	public void elimitarDetalleAlta(DetalleAlta DA) {
		listDetalleAlta.remove(DA);
	}

	
	public void setListDetalleAlta(Set<DetalleAlta> listDetalleAlta) {
		this.listDetalleAlta = listDetalleAlta;
	}

	@Override
	public String toString() {
		return "Servicio= "+super.toString()+ ", tensionContratada=" + tensionContratada + ", limite="
				+ limite + "]";
	}
	
	
	
}
