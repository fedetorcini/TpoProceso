package src.EstadosViaje;

import src.Viaje;

public interface IEstadoViaje {

public abstract void Confirmar(Viaje viaje);
public abstract void Cancelar(Viaje viaje);
public abstract void Reservar(Viaje viaje);
public abstract void Iniciar(Viaje viaje);
public abstract void Finalizar(Viaje viaje);

}
