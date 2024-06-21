package src.ReservaPackage;

import java.util.Date;

import src.PagoPackage.Pago;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;

public class Reserva {

private int nroReserva;
private Turista turista;
private Guia guia;
private Date fechaReserva;
private Pago pago;
private IEstadoReserva estado;

public void EnviarMensaje(String mensaje)
{
}

public void CambiarEstado(IEstadoReserva nuevoEstado)
{
	estado = nuevoEstado;
}

}
