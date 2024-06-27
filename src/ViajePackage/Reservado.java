package src.ViajePackage;

public class Reservado implements IEstadoViaje{

	@Override
	public void Confirmar(Viaje viaje) {
		viaje.CambiarEstado(new Confirmado());
	}
	@Override
	public void Cancelar(Viaje viaje) {viaje.CambiarEstado(new Cancelado());}
	@Override
	public void Iniciar(Viaje viaje) {
		System.out.println("El viaje debe confirmarse antes de ser iniciado.");
	}
	@Override
	public void Finalizar(Viaje viaje) {
		System.out.println("El viaje debde iniciarse antes de finalizar.");
	}
	@Override
	public String toString(){ return "Reservado"; }

}
