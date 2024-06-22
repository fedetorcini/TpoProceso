package src.NotificadorPackage.Mail;

import src.NotificadorPackage.Mensaje;

public class JavaMailAdapter implements NotificacionMailAdapter{

	@Override
	public void Enviar(Mensaje mensaje) {
		System.out.println("Enviado desde Mail JavaMail : " + mensaje);
	}

}
