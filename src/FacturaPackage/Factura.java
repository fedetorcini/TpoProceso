package src.FacturaPackage;

import java.util.Date;

import src.Itinerario;
import src.Pago;
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

public void CalcularImporte(Itinerario itinerario)
{
}

public void CambiarEstado(IEstadoFactura nuevoEstado)
{
	estado = nuevoEstado;
}

}
