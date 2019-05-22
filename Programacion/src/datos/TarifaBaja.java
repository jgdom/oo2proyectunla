package datos;

import java.util.Set;

public class TarifaBaja extends Tarifa{

	private Set<DetalleBaja> listDetalleBaja; //HIBERNET.INTERE

	public TarifaBaja() {
		super();
	}
	
	public TarifaBaja(String servicio) {
		super(servicio);
	}
	
	public Set<DetalleBaja> getListDetalleBaja() {
		return listDetalleBaja;
	}

	public void setListDetalleBaja(Set<DetalleBaja> listDetalleBaja) {
		this.listDetalleBaja = listDetalleBaja;
	}

	public void agregarDetalleBaja(DetalleBaja DB) {
		listDetalleBaja.add(DB);
	}
	
	public void elimitarDetalleBaja(DetalleBaja DB) {
		listDetalleBaja.remove(DB);
	}
	
	
	@Override
	public String toString() {
		return "Servicio= "+super.toString()+ "]";
	}
	
	
	
}
