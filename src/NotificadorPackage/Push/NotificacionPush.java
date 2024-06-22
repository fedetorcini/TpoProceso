package src.NotificadorPackage.Push;

import src.NotificadorPackage.IMedioNotificacion;
import src.NotificadorPackage.Mensaje;

public class NotificacionPush implements IMedioNotificacion{

	private NotificacionPushAdapter adapter;
	
	public NotificacionPush()
	{
	}
	
	@Override
	public void Enviar(Mensaje mensaje) {
		adapter.Enviar(mensaje);
	}
}
