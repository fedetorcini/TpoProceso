package src.ViajePackage;

public class Finalizado implements IEstadoViaje{

@Override
public void Confirmar(Viaje viaje) {
	System.out.println("El viaje ya fue finalizado");
}

@Override
public void Cancelar(Viaje viaje) {
	System.out.println("El viaje ya fue finalizado");
	
}

@Override
public void Iniciar(Viaje viaje) {
	System.out.println("El viaje ya fue finalizado");
	
}

@Override
public void Finalizar(Viaje viaje) {
	System.out.println("El viaje ya fue finalizado");	
}

}
