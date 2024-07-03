package src.ViajePackage.Estado;

import src.PagoPackage.PagoDTO;
import src.ViajePackage.Viaje;

public class Finalizado implements IEstadoViaje{
	@Override
	public boolean Reservar(Viaje viaje) {
		System.out.println("El viaje ya esta finalizado");
		return false;
	}
	@Override
	public boolean Pagar(Viaje viaje, PagoDTO pagoDto) {
		System.out.println("El viaje ya esta finalizado");
		return false;
	}
	@Override
	public boolean Rechazar(Viaje viaje) {
		System.out.println("El viaje ya esta finalizado");
		return false;
	}
	@Override
	public boolean Aceptar(Viaje viaje) {
		System.out.println("El viaje ya esta finalizado");
		return false;
	}
	@Override
	public boolean Cancelar(Viaje viaje) {
		System.out.println("El viaje ya esta finalizado");
		return false;
	}
	@Override
	public boolean Finalizar(Viaje viaje) {
		System.out.println("El viaje ya está Finalizado.");
		return false;
	}
	@Override
	public String toString(){
		return "Finalizado";
	}
}
