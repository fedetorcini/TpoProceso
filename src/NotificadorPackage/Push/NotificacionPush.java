package src.NotificadorPackage.Push;

import src.NotificadorPackage.IMedioNotificacion;

public class NotificacionPush implements IMedioNotificacion{

	private NotificacionPushAdapter adapter;
	
	public NotificacionPush()
	{
	}
	
	@Override
	public void Enviar(String mensaje) {
		adapter.Enviar(mensaje);
	}
}
