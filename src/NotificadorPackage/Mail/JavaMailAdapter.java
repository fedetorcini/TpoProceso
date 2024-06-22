package src.NotificadorPackage.Mail;

public class JavaMailAdapter implements NotificacionMailAdapter{

	@Override
	public void Enviar(String mensaje) {
		System.out.println("Enviado desde Mail JavaMail : " + mensaje);
	}

}
