package src.NotificadorPackage.Mail;

import src.NotificadorPackage.IMedioNotificacion;
import src.NotificadorPackage.Mensaje;

public class NotificacionMail implements IMedioNotificacion{

NotificacionMailAdapter adapter;

public NotificacionMail()
{
	this.adapter = new JavaMailAdapter();
}

@Override
public void Enviar(Mensaje mensaje) {
	adapter.Enviar(mensaje);
}

}
