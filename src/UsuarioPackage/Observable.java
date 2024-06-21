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
	if (!observadores.contains(observador))
	{
		observadores.add(observador);
		System.out.println("Suscripcion realizada con exito");
	}
	else
	{		
		System.out.println("Suscripcion ya existente");
	}
}

public void Desuscribir(IObservador observador)
{
	observadores.remove(observador);	
	System.out.println("Desuscripto con exito");
}

public void Publicar()
{
	for(IObservador observador : observadores)
	{
		observador.notificar(this);
	}
}

}
