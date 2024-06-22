package src.PagoPackage;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import src.Notificador.Mensaje;
import src.Observer.Observable;

public class Pago extends Observable<String>{

private static HashMap<Integer, Pago> pagos = new HashMap<Integer, Pago>();
private static int IDs = 0;
private int id;
private double monto;
private Date fecha;
private IAdapterPago metodoDePago;
private boolean fueExitoso;

private Pago(double nuevoMonto)
{
	monto = nuevoMonto;
	fecha = Calendar.getInstance().getTime();
	fueExitoso = false;
	metodoDePago = new StripAdapter();
	id = IDs;
	IDs++;
}

public double GetMonto() {
	return monto;
}

public static Pago RegistrarPago(double monto)
{
	Pago miPago = new Pago(monto);
	boolean success = miPago.RealizarPago();
	pagos.put(miPago.id, miPago);

	String mensaje;	
	
	if (success)
	{
		mensaje = "Pago de: " + monto + " realizado con exito.";
	}
	else
	{
		mensaje = "Pago por el monto de: " + monto + " falló.";
	}
	
	miPago.Publicar(mensaje);
	System.out.println(mensaje);
	
	return miPago;
}

private boolean RealizarPago() {
	return metodoDePago.RealizarPago(monto);
}

public boolean Completado() {
	return fueExitoso;
}

}
