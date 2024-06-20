package src.ViajePackage;

public class Cancelado implements IEstadoViaje{

@Override
public void Confirmar(Viaje viaje) {
	System.out.println("El viaje ya fue cancelado");
}

@Override
public void Cancelar(Viaje viaje) {
	System.out.println("El viaje ya fue cancelado");
}

@Override
public void Iniciar(Viaje viaje) {
	System.out.println("El viaje ya fue cancelado");	
}

@Override
public void Finalizar(Viaje viaje) {
	System.out.println("El viaje ya fue cancelado");	
}

}
