package src.UsuarioPackage;

import java.util.HashMap;

public class Guia extends Usuario{

private static HashMap<Integer, Guia> guias = new HashMap<Integer, Guia>();
private String pais;
private String ciudad;

private Guia(String nombre, String apellido, String mail, String sexo, int dni, int telefono, String pais, String ciudad) {
	super(nombre, apellido, mail, sexo, dni, telefono);
	this.ciudad = ciudad;
	this.pais = pais;
}


public void EnviarMensaje(String mensaje)
{}

public static Guia RegistrarGuia(String nombre, String apellido, String mail, String sexo, int dni, int telefono, String pais, String ciudad) {
	Guia miGuia = new Guia(nombre, apellido, mail, sexo, dni, telefono, pais, ciudad);
	
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
