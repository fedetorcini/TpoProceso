package src.ViajePackage.Estado;

import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

import java.util.ArrayList;

public class Pendiente implements IEstadoViaje{
    @Override
    public boolean Reservar(Viaje viaje) {
        System.out.println("El viaje debe ser aceptado.");
        return false;
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
    @Override
    public boolean Rechazar(Viaje viaje) {
        viaje.CambiarEstado(new Cancelado());
        for(Pago pago : viaje.GetPagos()){
            pago.Cancelar();
        }
        return true;
    }
    @Override
    public boolean Aceptar(Viaje viaje) {
        viaje.CambiarEstado(new Aceptado());
        return true;
    }
    @Override
    public boolean Cancelar(Viaje viaje) {
        viaje.CambiarEstado(new Cancelado());
        for(Pago pago : viaje.GetPagos()){
            pago.Cancelar();
        }
        return true;
    }
    @Override
    public boolean Finalizar(Viaje viaje) {
        System.out.println("El viaje no se puede finalizar.");
        return false;
    }
    @Override
    public String toString(){
        return "Pendiente";
    }
}
