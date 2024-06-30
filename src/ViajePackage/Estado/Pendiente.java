package src.ViajePackage.Estado;

import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pendiente implements IEstadoViaje{
    @Override
    public boolean Reservar(Viaje viaje) {
        double abonado = 0;
        boolean success = false;
        for (Pago pago : viaje.GetPagos()){
            abonado += pago.GetMonto();
        }
        if (abonado >= viaje.GetMinimo()){
            viaje.CambiarEstado(new Reservado());
            if (abonado >= viaje.GetCostoTotal())
            {
                viaje.CambiarEstado(new Confirmado());
            }
            success = true;
        }
        return success;
    }
    @Override
    public boolean Pagar(Viaje viaje, PagoDTO pagoDto) {
        Pago pago = new Pago();
        boolean success = pago.RegistrarPago(pagoDto.getMonto(), pagoDto.getTuristaId(), pagoDto.getGuiaId(), pagoDto.getViajeId());

        if(success){
            ArrayList<Pago> pagos = viaje.GetPagos();
            pagos.add(pago);
        }

        return success;
    }
}
