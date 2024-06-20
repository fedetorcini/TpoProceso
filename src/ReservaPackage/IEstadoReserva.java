package src.ReservaPackage;

public interface IEstadoReserva {

public abstract void Confirmar(Reserva reserva);
public abstract void MarcarPendiente(Reserva reserva);
public abstract void Cancelar(Reserva reserva);

}
