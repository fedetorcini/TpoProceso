package src.ObserverPackage;

import java.util.ArrayList;

import src.NotificadorPackage.Mensaje;

public class Observable<T>{

private ArrayList<IObservador<T>> observadores;

public Observable() 
{
	observadores = new ArrayList<IObservador<T>>();
}

public void Suscribir(IObservador<T> observador) {
	if (!observadores.contains(observador)) {
		observadores.add(observador);
	}
	else {
		System.out.println("Suscripcion ya existente");
	}
}

public void Desuscribir(IObservador<T> observador) {
	observadores.remove(observador);	
	System.out.println("Desuscripto con exito");
}

public void Publicar(T mensaje) {
	for(IObservador<T> observador : observadores)
	{
		observador.Notificar(mensaje);
	}
}

}
