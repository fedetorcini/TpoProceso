package src.UsuarioPackage;

import java.util.HashMap;

public class Turista extends Usuario {

private static HashMap<Integer, Turista> turistas = new HashMap<Integer, Turista>();
private Observable observable;

private Turista()
{
	observable = new Observable();
}

@Override
public String toString()
{
	return "NombreTurista";
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


public static Turista RegistrarTurista(String nombre, String apellido, String mail)
{
	Turista miTurista = new Turista();
	miTurista.SetApellido(apellido);
	miTurista.SetNombre(nombre);
	miTurista.SetId(IDs);
	miTurista.SetMail(mail);
	IDs++;
	
	turistas.put(miTurista.GetId(), miTurista);
	System.out.println("Turista " + nombre + " " + apellido + " registrado exitosamente");
	return miTurista;
}

}
