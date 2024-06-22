package src.PagoPackage;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Pago {

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
	
	if (success)
	{
		System.out.println("Pago de: " + monto + " realizado con exito");
	}
	else
	{
		System.out.println("Pago por el monto de: " + monto + " falló");
	}
	
	return miPago;
}

private boolean RealizarPago() {
	return metodoDePago.RealizarPago(monto);
}

public boolean Completado() {
	return fueExitoso;
}

}
