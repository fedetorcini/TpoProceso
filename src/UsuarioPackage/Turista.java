package src.UsuarioPackage;

import java.util.HashMap;

public class Turista extends Usuario {

private static HashMap<Integer, Turista> turistas = new HashMap<Integer, Turista>();
private Observable observable;


public Turista(String nombre, String apellido, String mail, String sexo, int dni, int telefono) {
	super(nombre, apellido, mail, sexo, dni, telefono);
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


public static Turista RegistrarTurista(String nombre, String apellido, String mail, String sexo, int dni, int telefono)
{
	Turista miTurista = new Turista(nombre, apellido, mail, sexo, dni, telefono);
	
	turistas.put(miTurista.GetId(), miTurista);
	System.out.println("Turista " + nombre + " " + apellido + " registrado exitosamente");
	return miTurista;
}

}
