package src.ViajePackage;

public class Confirmado implements IEstadoViaje {

	@Override
	public void Confirmar(Viaje viaje) {
		System.out.println("Viaje ya fue confirmado.");
	}

	@Override
	public void Cancelar(Viaje viaje) {
		System.out.println("No se puede cancelar un viaje confrmado.");
	}

	@Override
	public void Iniciar(Viaje viaje) {
		viaje.CambiarEstado(new Iniciado());
	}

	@Override
	public void Finalizar(Viaje viaje) {
		System.out.println("Antes de finalizar el viaje debe iniciarse.");
	}
	@Override
	public String toString(){ return "Confirmado"; }

}
