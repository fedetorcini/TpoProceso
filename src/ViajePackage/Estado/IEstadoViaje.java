package src.ViajePackage.Estado;

import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

public interface IEstadoViaje {

    boolean Reservar(Viaje viaje);
    boolean Pagar(Viaje viaje, PagoDTO pagoDto);
    boolean Rechazar(Viaje viaje);
    boolean Aceptar(Viaje viaje);
    boolean Cancelar(Viaje viaje);
    boolean Finalizar(Viaje viaje);
}
