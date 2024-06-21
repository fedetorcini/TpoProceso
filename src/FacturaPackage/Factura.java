package src.FacturaPackage;

import java.util.Date;

import src.PagoPackage.Pago;
import src.ViajePackage.Viaje;

import java.util.ArrayList;

public class Factura 
{
private Date fecha;
private double importe;
private ArrayList<Pago> pagos;
private IEstadoFactura estado;

public void GenerarFactura(Viaje viaje)
{
}

public void Enviar(Factura factura)
{
}

public void CambiarEstado(IEstadoFactura nuevoEstado)
{
	estado = nuevoEstado;
}

public void Pagar(double monto)
{
	double totalPagado = 0;
	
	Pago miPago = Pago.RegistrarPago(monto);
	if (miPago.Completado())
	{
		pagos.add(miPago);		
	}
	
	for(Pago unPago : pagos)
	{
		totalPagado += unPago.GetMonto();
	}
}
}
