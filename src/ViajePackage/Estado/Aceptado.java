package src.ViajePackage.Estado;

import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

import java.util.ArrayList;

public class Aceptado implements IEstadoViaje {
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
                viaje.CambiarEstado(new Finalizado());
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
    @Override
    public boolean Rechazar(Viaje viaje) {
        System.out.println("Un viaje aceptado no puede ser rechazado");
        return false;
    }
    @Override
    public boolean Aceptar(Viaje viaje) {
        System.out.println("El viaje ya se encuentra aceptado");
        return false;
    }
    @Override
    public boolean Cancelar(Viaje viaje) {

        ArrayList<Pago> pagos = viaje.GetPagos();
        boolean success = false;

        double penalidad = viaje.GetPenalidad();
        double abonado = 0;
        int indexPagoPenalidad = -1;
        double montoPagoPenalidad = 0;

        for (int i = 0; i < pagos.size(); i++){
            Pago pago = pagos.get(i);
            abonado += pago.GetMonto();
            if (abonado >= penalidad && abonado < montoPagoPenalidad){
                montoPagoPenalidad = abonado;
                indexPagoPenalidad = i;
            }
        }

        if (indexPagoPenalidad != -1)
        {
            pagos.get(indexPagoPenalidad).Cancelar();
            Pago pagoPenalidad = new Pago();
            success = pagoPenalidad.RegistrarPago(penalidad, viaje.GetTuristaId(), viaje.GetGuiaId(), viaje.GetId());
        }
        return success;
    }
    @Override
    public boolean Finalizar(Viaje viaje) {
        System.out.println("No puede finalizarse el viaje");
        return false;
    }
}
