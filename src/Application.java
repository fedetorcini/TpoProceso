package src;

import GUI.Principal;
import src.UsuarioPackage.Usuario;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.UsuarioPackage.LoginPackage.Apple;
import src.UsuarioPackage.LoginPackage.IMedioLogin;
import src.UsuarioPackage.LoginPackage.Mail;
import src.UsuarioPackage.TrofeoPackage.ControllerPackage.TrofeoController;
import src.UsuarioPackage.TrofeoPackage.ControllerPackage.TrofeoDTO;
import src.ViajePackage.Controller.ReseñaDTO;
import src.ViajePackage.Controller.ViajeController;
import src.ViajePackage.Controller.ViajeDTO;

public class Application {
	
public static void main(String[] args) {
	UsuarioController usuario = new UsuarioController();
	TrofeoController trofeo = new TrofeoController();
	ViajeController viaje = new ViajeController();

	TuristaDTO turista = null;
	TuristaDTO turistaPrueba = null;
	GuiaDTO guia = null;
	ViajeDTO miViaje = null;

	// Crear Turista para pruebas
	{
		String nombreTurista = "Federico";
		String apellidoTurista = "Torcini";
		String mailTurista = "mail";
		String contraseñaTurista = "contra";
		String sexoTurista = Usuario.MASCULINO;
		int dniTurista = 42496679;
		int telefonoTurista = 1167254331;
		String medioLoginTurista = UsuarioController.MEDIO_LOGIN_MAIL;
		turistaPrueba = usuario.RegistrarTurista(medioLoginTurista, nombreTurista, apellidoTurista, mailTurista, contraseñaTurista, sexoTurista, dniTurista, telefonoTurista); // Turista Federico Torcini registrado exitosamente
	}

	// Crear Turista
	{
		String nombreTurista = "Federico";
		String apellidoTurista = "Torcini";
		String mailTurista = "ftorcini@uade.edu.ar";
		String contraseñaTurista = "123456";
		String sexoTurista = Usuario.MASCULINO;
		int dniTurista = 42496679;
		int telefonoTurista = 1167254331;
		String medioLoginTurista = UsuarioController.MEDIO_LOGIN_APPLE; // No es posible conectarse con los servidores de Apple, intente otro metodo
		turista = usuario.RegistrarTurista(medioLoginTurista, nombreTurista, apellidoTurista, mailTurista, contraseñaTurista, sexoTurista, dniTurista, telefonoTurista); // Turista Federico Torcini no a podido ser registrado.
		medioLoginTurista = UsuarioController.MEDIO_LOGIN_MAIL;
		turista = usuario.RegistrarTurista(medioLoginTurista, nombreTurista, apellidoTurista, mailTurista, contraseñaTurista, sexoTurista, dniTurista, telefonoTurista); // Turista Federico Torcini registrado exitosamente
	}

	// Crear Guia
	{
		String nombreGuia = "Un";
		String apellidoGuia = "Guia";
		String mailGuia = "uguia@uade.edu.ar";
		String contraseñaGuia = "654321";
		String sexoGuia = Usuario.MASCULINO;
		int dniGuia = 36816684;
		int telefonoGuia = 11658469;
		String medioLoginGuia = UsuarioController.MEDIO_LOGIN_MAIL;
		guia = usuario.RegistrarGuia(medioLoginGuia, nombreGuia, apellidoGuia, mailGuia, contraseñaGuia, sexoGuia, dniGuia, telefonoGuia, "Argentina", "Buenos Aires"); // Guia Buenos Aires | Argentina registrado exitosamente
	}

	// Crear Trofeos Reseñas
	{
		TrofeoDTO trofeoTresReseñas = trofeo.RegistrarTrofeoReseña(3);
		trofeo.Suscribir(trofeoTresReseñas, turista); // Suscripcion realizada con exito

		TrofeoDTO trofeoPrimerReseñas = trofeo.RegistrarTrofeoReseña(1);
		trofeo.Suscribir(trofeoPrimerReseñas, turista); // Suscripcion realizada con exito
	}

	// Crear Trofeos Calificaciones
	{
		TrofeoDTO trofeoCalificacion = trofeo.RegistrarTrofeoCalificacion(4.5f);
		trofeo.Suscribir(trofeoCalificacion, guia); // Suscripcion realizada con exito
		trofeo.Suscribir(trofeoCalificacion, guia); // Suscripcion ya existente
	}

	// Viaje
	{
		miViaje = viaje.CrearViaje(turistaPrueba, guia);
		viaje.Reservar(miViaje); // Viaje reservado con exito.

		// Reseña
		{
			ReseñaDTO reseña = new ReseñaDTO();
			reseña.SetEstrellas(4.2f);
			reseña.SetGuia(guia);
			reseña.SetTexto("Muy buen viaje, gracias!!!");
			reseña.SetViaje(miViaje);
			reseña.SetTurista(turista);
			viaje.AgregarReseña(reseña);
		}

		viaje.EnviarMensaje(miViaje, /*new TuristaDTO(),*/ "Hola como estas?");
		viaje.EnviarMensaje(miViaje, /*new GuiaDTO(null),*/ "Yo bien y vos?");
	}

	Principal GUI = new Principal();
}

}
