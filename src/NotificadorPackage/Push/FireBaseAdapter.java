package src.NotificadorPackage.Push;

public class FireBaseAdapter implements NotificacionPushAdapter{

	@Override
	public void Enviar(String mensaje) {
		System.out.println("Enviado desde Push FireBase : " + mensaje);
	}

}
