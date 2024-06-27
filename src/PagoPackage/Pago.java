package src.PagoPackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import src.ObserverPackage.Observable;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.ViajePackage.Controller.ReseñaDTO;
import src.ViajePackage.Reseña;

public class Pago extends Observable<String>{

private static HashMap<Integer, Pago> pagos = new HashMap<Integer, Pago>();
private static int IDs = 0;
private int id;
private double monto;
private int turistaId;
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

	public Date getFecha() {
		return fecha;
	}

	public void RegistrarPago(double monto)
{
	this.monto = monto;
	this.fecha = Calendar.getInstance().getTime();
	this.metodoDePago = new StripAdapter();
	this.fueExitoso = RealizarPago();
	this.id = IDs;
	IDs++;
	
	pagos.put(id, this);

	String mensaje;	
	
	if (fueExitoso)
	{
		mensaje = "Pago de: " + monto + " realizado con exito.";
	}
	else
	{
		mensaje = "Pago por el monto de: " + monto + " falló.";
	}
	
	Publicar(mensaje);
	System.out.println(mensaje);
}


private boolean RealizarPago() {
	return metodoDePago.RealizarPago(monto);
}

public boolean Completado() {
	return fueExitoso;
}
	public static ArrayList<PagoDTO> getPagosDTO() {
		ArrayList<PagoDTO> pagoDTOS = new ArrayList<>();

		for (Pago pago : pagos.values()){
			pagoDTOS.add(new PagoDTO(pago));
		}
		return pagoDTOS;
	}

}
