package src.ViajePackage;

public class Iniciado implements IEstadoViaje{

	@Override
	public void Confirmar(Viaje viaje) {
	System.out.println("Viaje ya fue iniciado.");
	}
	@Override
	public void Cancelar(Viaje viaje) {
	System.out.println("Viaje ya fue iniciado.");
	}
	@Override
	public void Iniciar(Viaje viaje) {
	System.out.println("Viaje ya fue iniciado.");
	}
	@Override
	public void Finalizar(Viaje viaje) {
	viaje.CambiarEstado(new Finalizado());
	}
	@Override
	public String toString(){ return "Iniciado"; }
}
