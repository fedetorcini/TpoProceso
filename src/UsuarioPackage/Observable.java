package src.UsuarioPackage;

import java.util.ArrayList;

public class Observable {

private ArrayList<IObservador> observadores;

public Observable() 
{
	observadores = new ArrayList<IObservador>();
}

public void Suscribir(IObservador observador)
{
	observadores.add(observador);
	System.out.println("Suscripcion realizada con exito");
}

public void Desuscribir(IObservador observador)
{
	observadores.remove(observador);	
}

public void Publicar()
{
	for(IObservador observador : observadores)
	{
		observador.notificar(this);
	}
}

}
