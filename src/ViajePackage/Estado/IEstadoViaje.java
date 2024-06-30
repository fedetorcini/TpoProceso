package src.ViajePackage.Estado;

import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

public interface IEstadoViaje {

    boolean Reservar(Viaje viaje);
    boolean Pagar(Viaje viaje, PagoDTO pagoDto);
}
