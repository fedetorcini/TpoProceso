package src.UsuarioPackage.LoginPackage;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.HashMap;

public class Mail implements IMedioLogin {

private static HashMap<String, String> usuarios = new HashMap<String, String>();

@Override
public boolean RegistrarUsuario(String mail, String contraseña) {
	boolean success = false;
	if(usuarios.containsKey(mail))
	{
		System.out.println("Usuario ya registrado");
	}
	else
	{
		usuarios.put(mail, contraseña);
		success = true;
	}
	
	return success;
}

@Override
public boolean Login(String mail, String contraseña) {
	boolean success = false;
	if(usuarios.containsKey(mail))
	{
		if (usuarios.get(mail).equals(contraseña))
		{
			System.out.println("Usuario loggeado con exito.");
			success = true;
		}
		else
		{
			System.out.println("Contraseña incorrecta.");
		}
	}
	else
	{
		System.out.println("No se encontr[o un usuario con ese mail");
	}
	
	return success;
}

}
