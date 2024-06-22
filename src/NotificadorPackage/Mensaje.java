package src.NotificadorPackage;

import src.UsuarioPackage.Usuario;

public class Mensaje {

private Usuario emisor;
private String descripcion;
private Notificador notificador;

public Mensaje(Usuario turista, String texto, Notificador notificador) {
	this.emisor = emisor;
	this.descripcion = texto;
	this.notificador = notificador;
}

public Mensaje(String mensaje) {
	this.descripcion = mensaje;
}

public Usuario GetEmisor() {
	return emisor;
}
public void SetEmisor(Usuario emisor) {
	this.emisor = emisor;
}
public String GetDescripcion() {
	return descripcion;
}
public void SetDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

@Override
public String toString()
{
	return descripcion;
}

public boolean SoyElEmisor(Notificador evaluado) {
	
	boolean evaluacion = false;
	if (evaluado != null)
	{
		if (evaluado == this.notificador)
		{
			evaluacion = true;
		}
	}
	return evaluacion;
}
	
}
