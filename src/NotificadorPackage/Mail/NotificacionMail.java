package src.NotificadorPackage.Mail;

import src.NotificadorPackage.IMedioNotificacion;

public class NotificacionMail implements IMedioNotificacion{

	NotificacionMailAdapter adapter;
	
	public NotificacionMail()
	{
		this.adapter = new JavaMailAdapter();
	}
	
	@Override
	public void Enviar(String mensaje) {
		adapter.Enviar(mensaje);
	}

}
