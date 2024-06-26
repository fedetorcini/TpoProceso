package src.UsuarioPackage;

import java.util.HashMap;

import src.NotificadorPackage.IMedioNotificacion;
import src.NotificadorPackage.Notificador;
import src.ObserverPackage.Observable;
import src.UsuarioPackage.LoginPackage.IMedioLogin;
import src.ViajePackage.Viaje;

public abstract class Usuario<T> extends Observable<T>{

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

protected Usuario()
{
	viajes = new HashMap<Integer, Viaje>();
}

protected void InitializeUsuario(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
	this.medioLogin = medioLogin;
	this.nombre = nombre;
	this.apellido = apellido;
	this.mail = mail;
	this.sexo = sexo;
	this.dni = dni;
	this.telefono = telefono;
	this.viajes = new HashMap<Integer, Viaje>();
	this.notificador = new Notificador();
}

public abstract void ActualizarPerfil(String nombre, String apellido, String sexo, int telefono, int dni);

public void CambiarMetodoLogin(IMedioLogin nuevoMedio)
{
	medioLogin = nuevoMedio;
}

public void CambiarMetodoNotificacion(IMedioNotificacion nuevoMedio) {
}

public Notificador GetNotificador()
{
	return notificador;
}

public String GetMail() {
	return mail;
}

public int GetId()
{
	return id;
}

public String GetNombre() {
	return nombre;
}

public String GetApellido() {
	return apellido;
}

public int GetDni() {
	return dni;
}

public int GetTelefono() {
	return telefono;
}

public String GetSexo() {
	return sexo;
}

public void SetNombre(String nombre) { this.nombre = nombre; }

public void SetApellido(String apellido) { this.apellido = apellido; }

public void SetSexo(String sexo) {	this.sexo = sexo; }

public void SetTelefono(int telefono) { this.telefono = telefono; }

public void SetDni(int dni) { this.dni = dni;}

}
