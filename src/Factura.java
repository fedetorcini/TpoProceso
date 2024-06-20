package src;

import java.util.Date;

import src.EstadosFactura.IEstadoFactura;

import java.util.ArrayList;

public class Factura 
{
public Date fecha;
public double importe;
public ArrayList<Pago> pagos;

public void GenerarFactura(Viaje viaje)
{
}

public void Enviar(Factura factura)
{
}

public void CalcularImporte(Itinerario itinerario)
{
}

public void CambiarEstado(IEstadoFactura estado)
{
}

}
