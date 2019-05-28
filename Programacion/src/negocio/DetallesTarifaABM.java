package negocio;

import java.util.List;
import dao.DetallesTarifaDao;
import datos.DetalleAlta;
import datos.DetalleBaja;
import datos.TarifaAlta;
import datos.TarifaBaja;

public class DetallesTarifaABM {

	private static DetallesTarifaABM instancia;
	private DetallesTarifaDao dao = DetallesTarifaDao.getInstancia();
	
	protected DetallesTarifaABM() {}
	
	public static DetallesTarifaABM getInstancia() {
		if(instancia == null) {
			instancia = new DetallesTarifaABM();
		}
		return instancia;
	}
	
	public DetalleBaja TraerDetalleBaja(int id) {
		return dao.TraerDetalleBaja(id);
	}
	
	public DetalleAlta TraerDetalleAlta(int id) {
		return dao.TraerDetalleAlta(id);
	}
	
	public List<DetalleBaja> TraerTodasLasDetalleBaja(){
		return dao.TraerTodasLasDetalleBaja();
	}
	
	public List<DetalleAlta> TraerTodasLasDetalleAlta(){
		return dao.TraerTodasLasDetalleAlta();
	}
	
	//-----------------------------------------------------------
	
	public int agregarDetalleBaja(String detalleConceptos,String unidad, int desde, int hasta, double valor, TarifaBaja tarifaBaja) {
		return dao.agregarDetalleBaja(detalleConceptos, unidad, desde, hasta, valor, tarifaBaja);
	}

	public int agregarDetalleAlta(String detalleConceptos, String unidad, boolean superaLimite, double valor, TarifaAlta tarifaAlta) {
		return dao.agregarDetalleAlta(detalleConceptos, unidad, superaLimite, valor, tarifaAlta);
	}

	public List<DetalleBaja>  TraerTodasLasDetalleBajaDeUnaTarifa(int idTarifaBaja) {
		return dao.TraerTodasLasDetalleBajaDeUnaTarifa(idTarifaBaja);
	}

	public List<DetalleAlta>  TraerTodasLasDetalleAltaDeUnaTarifa(int idTarifa) {
		return dao.TraerTodasLasDetalleAltaDeUnaTarifa(idTarifa);
	}
	
}
