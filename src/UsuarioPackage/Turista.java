package src.UsuarioPackage;

import java.util.HashMap;

import src.UsuarioPackage.LoginPackage.IMedioLogin;
import src.UsuarioPackage.TrofeoPackage.IObservador;
import src.UsuarioPackage.TrofeoPackage.Observable;

public class Turista extends Usuario {

private static HashMap<Integer, Turista> turistas = new HashMap<Integer, Turista>();
private Observable observable;

public Turista(String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
	super(nombre, apellido, mail, contraseña, sexo, dni, telefono);
	observable = new Observable();
}

@Override
public String toString()
{
	return nombre + " " + apellido;
}

public void Suscribir(IObservador observer) {
	observable.Suscribir(observer);
}

public void Desuscribir(IObservador observador)
{
	observable.Desuscribir(observador);
}

public void Publicar()
{
	observable.Publicar();
}

public static Turista RegistrarTurista(IMedioLogin medioLoginGuia, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono)
{
	Turista miTurista = null;
	
	if (medioLoginGuia.RegistrarUsuario(mail, contraseña))
	{
		miTurista = new Turista(nombre, apellido, mail, contraseña, sexo, dni, telefono);
		turistas.put(miTurista.GetId(), miTurista);
		System.out.println("Turista " + nombre + " " + apellido + " registrado exitosamente.");
		
	}
	else
	{
		System.out.println("Turista " + nombre + " " + apellido + " no a podido ser registrado.");	
	}
	
	return miTurista;
}

}
