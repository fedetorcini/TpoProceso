package src.UsuarioPackage;

import java.util.HashMap;

import src.UsuarioPackage.LoginPackage.IMedioLogin;

public class Turista extends Usuario<Turista>{

private static HashMap<Integer, Turista> turistas = new HashMap<Integer, Turista>();

public Turista(String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
	super(nombre, apellido, mail, contraseña, sexo, dni, telefono);
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

@Override
public String toString()
{
	return nombre + " " + apellido;
}

}
