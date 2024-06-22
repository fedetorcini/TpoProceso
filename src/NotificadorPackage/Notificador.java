package src.NotificadorPackage;

import src.NotificadorPackage.Mail.NotificacionMail;
import src.ObserverPackage.IObservador;

public class Notificador implements IObservador<String>{
	
private IMedioNotificacion medioNotificacion;

public Notificador()
{
	this.medioNotificacion = new NotificacionMail();
}

public void CambiarMedioNotificacion(IMedioNotificacion nuevoMedio)
{
	this.medioNotificacion = nuevoMedio;
}

@Override
public void Notificar(String object) {
	medioNotificacion.Enviar(object);	
}

}
