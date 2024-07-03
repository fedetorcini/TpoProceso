package src.ViajePackage.Estado;

import src.NotificadorPackage.Mensaje;
import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

public interface IEstadoViaje {

    boolean Reservar(Viaje viaje, Mensaje mensaje);
    boolean Pagar(Viaje viaje, PagoDTO pagoDto, Mensaje mensaje);
    boolean Rechazar(Viaje viaje, Mensaje mensaje);
    boolean Aceptar(Viaje viaje, Mensaje mensaje);
    boolean Cancelar(Viaje viaje, Mensaje mensaje);
    boolean Finalizar(Viaje viaje, Mensaje mensaje);
}
