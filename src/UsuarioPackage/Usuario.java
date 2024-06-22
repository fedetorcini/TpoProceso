package src.UsuarioPackage;

import java.util.HashMap;

import src.NotificadorPackage.Notificador;
import src.ObserverPackage.Observable;
import src.UsuarioPackage.LoginPackage.IMedioLogin;
import src.ViajePackage.Viaje;

public class Usuario<T> extends Observable<T>{

public static final String MASCULINO = "Masculino";
public static final String FEMENINO = "Femenino";
protected static int IDs = 0;
protected int id;
protected String nombre;
protected String apellido;
protected String mail;
protected String sexo;
protected int dni;
protected int telefono;
protected IMedioLogin medioLogin;
protected HashMap<Integer, Viaje> viajes;
protected Notificador notificador;

protected Usuario(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
	this.id = IDs;
	IDs++;
	this.medioLogin = medioLogin;
	this.nombre = nombre;
	this.apellido = apellido;
	this.mail = mail;
	this.sexo = sexo;
	this.dni = dni;
	this.telefono = telefono;
	this.viajes = new HashMap<Integer, Viaje>();
}

protected int GetId() {
	return id;
}

protected void SetId(int myId) {
	this.id = myId;
}

protected String GetApellido() {
	return apellido;
}

protected void SetApellido(String apellido) {
	this.apellido = apellido;
}

protected String GetNombre() {
	return nombre;
}

protected void SetNombre(String nombre) {
	this.nombre = nombre;
}

protected String GetMail() {
	return mail;
}

protected void SetMail(String mail) {
	this.mail = mail;
}

public void CambiarMetodoLogin(IMedioLogin nuevoMedio)
{
	medioLogin = nuevoMedio;
}

public void AgregarViaje(Viaje nuevoViaje)
{
	viajes.put(nuevoViaje.GetId(), nuevoViaje);
}

}
