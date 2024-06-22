package src.NotificadorPackage.Push;

import src.NotificadorPackage.Mensaje;

public class FireBaseAdapter implements NotificacionPushAdapter{

@Override
public void Enviar(Mensaje mensaje) {
	System.out.println("Enviado desde Push FireBase : " + mensaje);
}

}
