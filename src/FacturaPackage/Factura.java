package src.FacturaPackage;

import java.util.Date;

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
	
	pagos.add(new Pago(monto));
	
	for(Pago pago : pagos)
	{
		totalPagado += pago.GetMonto();
	}
}
}
