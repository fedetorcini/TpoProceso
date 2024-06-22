package src.Notificador;

import src.Observer.IObservador;

public class Notificador implements IObservador<String>{
	@Override
	public void Notificar(String object) {
		System.out.println(object);
		
	}

}
