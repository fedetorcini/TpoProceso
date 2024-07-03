package src.ViajePackage.Estado;

import src.NotificadorPackage.Mensaje;
import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

import java.util.ArrayList;

public class Pendiente implements IEstadoViaje{
    @Override
    public boolean Reservar(Viaje viaje, Mensaje mensaje) {
        System.out.println("El viaje debe ser aceptado.");
        return false;
    }
    @Override
    public boolean Pagar(Viaje viaje, PagoDTO pagoDto, Mensaje mensaje) {
        Pago pago = new Pago();
        boolean success = pago.RegistrarPago(pagoDto.getMonto(), pagoDto.getTuristaId(), pagoDto.getGuiaId(), pagoDto.getViajeId());

        if(success){
            ArrayList<Pago> pagos = viaje.GetPagos();
            pagos.add(pago);
            mensaje.SetDescripcion("Turista : " + viaje.GetTuristaId() + " ha realizado un pago por : " + pagoDto.getMonto());
        }
        else {
            mensaje.SetDescripcion("Se ha rechazado un pago por el monto de " + pagoDto.getMonto() + " para el viaje :" + viaje.GetId());
        }

        return success;
    }
    @Override
    public boolean Rechazar(Viaje viaje, Mensaje mensaje) {
        viaje.CambiarEstado(new Cancelado());
        for(Pago pago : viaje.GetPagos()){
            pago.Cancelar();
        }
        mensaje.SetDescripcion("Guia : " + viaje.GetGuiaId() + " ha rechazado el viaje " + viaje.GetId() + ".");
        return true;
    }
    @Override
    public boolean Aceptar(Viaje viaje, Mensaje mensaje) {
        viaje.CambiarEstado(new Aceptado());
        mensaje.SetDescripcion("Guia : " + viaje.GetGuiaId() + " ha aceptado el viaje " + viaje.GetId() + ".");
        return true;
    }
    @Override
    public boolean Cancelar(Viaje viaje, Mensaje mensaje) {
        viaje.CambiarEstado(new Cancelado());
        for(Pago pago : viaje.GetPagos()){
            pago.Cancelar();
        }

        mensaje.SetDescripcion("Turista : a cancelado el viaje : " + viaje.GetId() + ". NO se aplicara una penalidad.");
        return true;
    }
    @Override
    public boolean Finalizar(Viaje viaje, Mensaje mensaje) {
        System.out.println("El viaje no se puede finalizar.");
        return false;
    }
    @Override
    public String toString(){
        return "Pendiente";
    }
}
