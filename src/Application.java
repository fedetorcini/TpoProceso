package src;

import src.UsuarioPackage.Trofeo;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.Usuario;
import src.ViajePackage.Viaje;

public class Application {
	
public static void main(String[] args)
{
	Viaje miViaje;
			
	String nombre = "Federico";
	String apellido = "Torcini";
	String mail = "ftorcini@uade.edu.ar";
	
	Usuario usuario = Usuario.RegistrarUsuario(nombre, apellido, mail);
	Turista turista = new Turista();
	Trofeo trofeo = Trofeo.RegistrarTrofeo(3);
	turista.Suscribir(trofeo);
}

}
