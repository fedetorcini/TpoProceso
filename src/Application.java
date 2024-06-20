package src;

import src.Usuario.Usuario;

public class Application {
	
	public static void main(String[] args)
	{
		Viaje miViaje;
		System.out.println("Hello World");
				
		String nombre = "Federico";
		String apellido = "Torcini";
		String mail = "ftorcini@uade.edu.ar";
		
		Usuario usuario = Usuario.RegistrarUsuario(nombre, apellido, mail);
		
	}
}
