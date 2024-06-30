package src.ViajePackage.Estado;

import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

public class Iniciado implements IEstadoViaje{

	@Override
	public boolean Reservar(Viaje viaje) {
		return false;
	}
	@Override
	public boolean Pagar(Viaje viaje, PagoDTO pagoDto) {
		return false;
	}
}
