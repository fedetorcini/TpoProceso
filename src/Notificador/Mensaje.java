package src.Notificador;

import src.UsuarioPackage.Usuario;

public class Mensaje {

private Usuario emisor;
private String descripcion;
private Usuario receptor;

public Usuario GetReceptor() {
	return receptor;
}
public void SetReceptor(Usuario receptor) {
	this.receptor = receptor;
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
	
}
