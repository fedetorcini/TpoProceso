package src.FacturaPackage;

import java.util.Date;

import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
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

public void Pagar(PagoDTO pagoDto)
{
	double totalPagado = 0;
	
	Pago miPago = new Pago();
	miPago.RegistrarPago(pagoDto);
	
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
