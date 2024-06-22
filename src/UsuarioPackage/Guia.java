package src.UsuarioPackage;

import java.util.HashMap;

import src.UsuarioPackage.LoginPackage.IMedioLogin;

public class Guia extends Usuario{

private static HashMap<Integer, Guia> guias = new HashMap<Integer, Guia>();
private String pais;
private String ciudad;

private Guia(String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
	super(nombre, apellido, mail, contraseña, sexo, dni, telefono);
	this.ciudad = ciudad;
	this.pais = pais;
}


public void EnviarMensaje(String mensaje)
{}

public static Guia RegistrarGuia(IMedioLogin medioLoginGuia, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
	Guia miGuia = new Guia(nombre, apellido, mail, contraseña, sexo, dni, telefono, pais, ciudad);
	
	boolean success = miGuia.medioLogin.RegistrarUsuario(mail, contraseña);
	guias.put(miGuia.GetId(), miGuia);
	
	System.out.println("Guia " + miGuia + " fue creado exitosamente");
	return miGuia;
}

@Override
public String toString()
{
	return ciudad + " | " + pais;
}

}
