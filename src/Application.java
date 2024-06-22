package src;

import src.NotificadorPackage.Notificador;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.Usuario;
import src.UsuarioPackage.LoginPackage.Apple;
import src.UsuarioPackage.LoginPackage.IMedioLogin;
import src.UsuarioPackage.LoginPackage.Mail;
import src.UsuarioPackage.TrofeoPackage.TrofeoCalificacion;
import src.UsuarioPackage.TrofeoPackage.TrofeoReseña;
import src.ViajePackage.Viaje;

public class Application {
	
public static void main(String[] args)
{			
	String nombreTurista = "Federico";
	String apellidoTurista = "Torcini";
	String mailTurista = "ftorcini@uade.edu.ar";
	String contraseñaTurista = "123456";
	String sexoTurista = Usuario.MASCULINO;
	int dniTurista = 42496679;
	int telefonoTurista = 1167254331;
	IMedioLogin medioLoginTurista = new Apple(); // No es posible conectarse con los servidores de Apple, intente otro metodo
	Turista turista = Turista.RegistrarTurista(medioLoginTurista, nombreTurista, apellidoTurista, mailTurista, contraseñaTurista, sexoTurista, dniTurista, telefonoTurista); // Turista Federico Torcini no a podido ser registrado.
	medioLoginTurista = new Mail();
	turista = Turista.RegistrarTurista(medioLoginTurista, nombreTurista, apellidoTurista, mailTurista, contraseñaTurista, sexoTurista, dniTurista, telefonoTurista); // Turista Federico Torcini registrado exitosamente	

	TrofeoReseña trofeoTresReseñas = TrofeoReseña.RegistrarTrofeo(3); // Trofeo con id 0 y rese�as necesarias 3 fue creado exitosamente.
	turista.Suscribir(trofeoTresReseñas); // Suscripcion realizada con exito
	
	TrofeoReseña trofeoPrimerReseña = TrofeoReseña.RegistrarTrofeo(1); // Trofeo con id 1 y rese�as necesarias 1 fue creado exitosamente.
	turista.Suscribir(trofeoPrimerReseña); // Suscripcion realizada con exito
	
	
	String nombreGuia = "Un";
	String apellidoGuia = "Guia";
	String mailGuia = "uguia@uade.edu.ar";
	String contraseñaGuia = "654321";
	String sexoGuia = Usuario.MASCULINO;
	int dniGuia = 36816684;
	int telefonoGuia = 11658469;
	IMedioLogin medioLoginGuia = new Mail();
	Guia guia = Guia.RegistrarGuia(medioLoginGuia, nombreGuia, apellidoGuia, mailGuia, contraseñaGuia, sexoGuia, dniGuia, telefonoGuia, "Argentina", "Buenos Aires"); // Guia Buenos Aires | Argentina registrado exitosamente
	
	TrofeoCalificacion trofeoCalificacionCuatroEstrellas = TrofeoCalificacion.RegistrarTrofeo(4); // Trofeo con id 2 y calificacion necesaria 4 fue creado exitosamente.
	guia.Suscribir(trofeoCalificacionCuatroEstrellas); // Suscripcion realizada con exito
	guia.Suscribir(trofeoCalificacionCuatroEstrellas); // Suscripcion ya existente

	
	Notificador centroDeNotificacion = new Notificador();
	trofeoTresReseñas.Suscribir(centroDeNotificacion); // Suscripcion realizada con exito
	trofeoPrimerReseña.Suscribir(centroDeNotificacion); // Suscripcion realizada con exito
	trofeoCalificacionCuatroEstrellas.Suscribir(centroDeNotificacion); // Suscripcion realizada con exito
	
	Viaje viaje = Viaje.CrearViaje(turista); // Viaje creado con exito
	viaje.Reservar(); // Viaje no puede ser reservado sin guia.
	viaje.SeleccionarGuia(guia);
	viaje.Reservar(); // Viaje reservado con exito.	
	turista.AgregarViaje(viaje);
	guia.AgregarViaje(viaje);
	
	turista.AgregarReseña(viaje.GetId());
	
	turista.EnviarMensajeEnViaje(viaje.GetId(), "Hola como estas?");
	guia.EnviarMensajeEnViaje(viaje.GetId(), "Yo bien y vos?");
	
}

}
