package src.ViajePackage;

import java.util.ArrayList;

import src.NotificadorPackage.Mensaje;
import src.ObserverPackage.Observable;
import src.ViajePackage.Controller.MensajeDTO;

public class Chat extends Observable<Mensaje>{

public int turistaId;
public int guiaId;
private ArrayList<Mensaje> mensajes;

public Chat(int turistaId, int guiaId) {
	this.turistaId = turistaId;
	this.guiaId = guiaId;
	this.mensajes = new ArrayList<Mensaje>();
}
	
public void EnviarMensaje(Mensaje nuevoMensaje) {
	mensajes.add(nuevoMensaje);
	Publicar(nuevoMensaje);		
}

public ArrayList<MensajeDTO> GetMensajes() {
	ArrayList<MensajeDTO> mensajesDto = new ArrayList<MensajeDTO>();

	for (Mensaje mensaje : mensajes){
		mensajesDto.add(new MensajeDTO(mensaje));
	}
	return mensajesDto;
}

}
