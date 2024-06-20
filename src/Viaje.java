package src;

import src.EstadosViaje.IEstadoViaje;

public class Viaje {

	
private int nroReserva;
private Itinerario itinerario;
private Guia guia;
private Turista turista;
private double costoTotal;
private double penalidad;
private IEstadoViaje estadoViaje;

public void ResgistrarReserva(Reserva reserva, Itinerario itinerario)
{}

public double CalcularPenalidad(Itinerario itinerario)
{
	return penalidad;
}

public void CambiarEstado(IEstadoViaje estado)
{}

}
