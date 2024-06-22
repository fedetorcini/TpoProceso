package src.UsuarioPackage;

import java.util.ArrayList;
import java.util.HashMap;

import src.Reseña;
import src.UsuarioPackage.LoginPackage.IMedioLogin;

public class Guia extends Usuario<Guia>{

private static HashMap<Integer, Guia> guias = new HashMap<Integer, Guia>();
private String pais;
private String ciudad;
private ArrayList<Float> calificaciones;

private Guia(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
	super(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono);
	this.ciudad = ciudad;
	this.pais = pais;
	this.calificaciones = new ArrayList<Float>();
}

public static Guia RegistrarGuia(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
	Guia miGuia = new Guia(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono, pais, ciudad);
	
	boolean success = medioLogin.RegistrarUsuario(mail, contraseña);
	guias.put(miGuia.GetId(), miGuia);
	
	System.out.println("Guia " + miGuia + " fue creado exitosamente");
	return miGuia;
}

@Override
public String toString()
{
	return ciudad + ", " + pais;
}


public float GetPromedio() {
	float promedio = 0;
	for(Float calificacion : calificaciones)
	{
		promedio += calificacion;
	}
	return promedio / calificaciones.size();
}

public void AgregarReseña(Reseña reseña)
{
	calificaciones.add(reseña.GetCalificacion());
	Publicar(this);
}



}
