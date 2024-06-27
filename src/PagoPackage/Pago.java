package src.PagoPackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import src.NotificadorPackage.Mensaje;
import src.ObserverPackage.Observable;

public class Pago extends Observable<Mensaje>{

	private static HashMap<Integer, Pago> pagos = new HashMap<Integer, Pago>();
	private static int IDs = 0;
	private int id;
	private double monto;
	private int turistaId;
	private int guiaId;
	private Date fecha;
	private IAdapterPago metodoDePago;
	private boolean fueExitoso;

	public double GetMonto() {
	return monto;
}

	public int getId() {return id;}

	public int getTuristaId() {
		return turistaId;
	}

	public void setTuristaId(int turistaId) {
		this.turistaId = turistaId;
	}

	public int getGuiaId() {
		return guiaId;
	}

	public void setGuiaId(int guiaId) {
		this.guiaId = guiaId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void RegistrarPago(PagoDTO pagoDto) {
		RegistrarPago(pagoDto.GetMonto(), pagoDto.getTuristaId(), pagoDto.getGuiaId());
	}

	public void RegistrarPago(double monto, int turistaId, int guiaId) {
	    this.turistaId = turistaId;
		this.guiaId = guiaId;
		this.monto = monto;
		this.fecha = Calendar.getInstance().getTime();
		this.metodoDePago = new StripAdapter();
		this.fueExitoso = RealizarPago();
		this.id = IDs;
		IDs++;

		pagos.put(id, this);

		Mensaje mensaje = new Mensaje(" ");

		if (fueExitoso) {
			mensaje.SetDescripcion("Pago de: " + monto + " realizado con exito.");
		}
		else {
			mensaje.SetDescripcion("Pago por el monto de: " + monto + " falló.");
		}

		Publicar(mensaje);
	}

	private boolean RealizarPago() { return metodoDePago.RealizarPago(monto); }

	public boolean Completado() { return fueExitoso; }

	public static ArrayList<PagoDTO> getPagosDTO() {
		ArrayList<PagoDTO> pagoDTOS = new ArrayList<>();

		for (Pago pago : pagos.values()){
			pagoDTOS.add(new PagoDTO(pago));
		}
		return pagoDTOS;
	}

}
