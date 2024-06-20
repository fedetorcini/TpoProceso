package src.ViajePackage;

import src.Reseña;
import src.ReservaPackage.Reserva;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;

public class Viaje {

private int nroReserva;
private Guia guia;
private Turista turista;
private double costoTotal;
private double penalidad;
private IEstadoViaje estadoViaje;
private Reseña reseña;

public void ResgistrarReserva(Reserva reserva)
{}

public double CalcularPenalidad()
{
	return penalidad;
}

public void CambiarEstado(IEstadoViaje estado)
{}

public void RegistrarReseña(String mensaje)
{
	reseña = Reseña.RegistrarReseña(mensaje, turista, guia, 5);
}

}
