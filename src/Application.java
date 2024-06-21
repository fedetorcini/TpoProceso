package src;

import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Trofeo;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.Usuario;
import src.ViajePackage.Viaje;

public class Application {
	
public static void main(String[] args)
{			
	String nombre = "Federico";
	String apellido = "Torcini";
	String mail = "ftorcini@uade.edu.ar";
	Usuario usuario = Usuario.RegistrarUsuario(nombre, apellido, mail); // Usuario Federico Torcini registrado exitosamente
	Turista turista = new Turista();		
	
	Trofeo trofeoTresReseñas = Trofeo.RegistrarTrofeo(3); // Trofeo con id 0 y rese�as necesarias 3 fue creado exitosamente.
	turista.Suscribir(trofeoTresReseñas); // Suscripcion realizada con exito
	
	Trofeo trofeoPrimerReseña = Trofeo.RegistrarTrofeo(1); // Trofeo con id 1 y rese�as necesarias 1 fue creado exitosamente.
	turista.Suscribir(trofeoPrimerReseña); // Suscripcion realizada con exito
	
	Guia guia = Guia.RegistrarGuia("Argentina", "Buenos Aires"); // Guia Buenos Aires | Argentina fue creado exitosamente
	Viaje viaje = Viaje.CrearViaje(turista); // Viaje creado con exito
	viaje.Reservar(); // Viaje no puede ser reservado sing guia.
	viaje.SeleccionarGuia(guia);
	viaje.Reservar(); // Viaje reservado con exito.
}

}
