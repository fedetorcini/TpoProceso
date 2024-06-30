package src.ViajePackage.Estado;

import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

public class Cancelado implements IEstadoViaje{

	@Override
	public boolean Reservar(Viaje viaje) {
		System.out.println("El viaje no puede pagarse por que ya está cancelado");
		return false;
	}
	@Override
	public boolean Pagar(Viaje viaje, PagoDTO pagoDto) {
		System.out.println("El viaje no puede pagarse por que ya está cancelado");
		return false;
	}

}
