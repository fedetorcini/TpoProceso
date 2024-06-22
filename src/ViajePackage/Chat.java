package src.ViajePackage;

import java.util.ArrayList;

import src.NotificadorPackage.Mensaje;
import src.ObserverPackage.Observable;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.Usuario;

public class Chat extends Observable<Mensaje>{

public Usuario<Turista> turista;
public Usuario<Guia> guia;
private ArrayList<Mensaje> mensajes;
	
public Chat(Turista turista, Guia guia)
{
	this.turista = turista;
	this.guia = guia;
	this.mensajes = new ArrayList<Mensaje>();
	System.out.println("Chat establecido con exito");
}
	
public void EnviarMensaje(Mensaje nuevoMensaje)
{
	mensajes.add(nuevoMensaje);
	Publicar(nuevoMensaje);		
}

}
