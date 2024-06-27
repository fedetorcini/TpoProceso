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
import src.ViajePackage.ServicioPackage.ServicioDTO;

public class Application {
	
public static void main(String[] args) {
	UsuarioController usuario = new UsuarioController();
	TrofeoController trofeo = new TrofeoController();
	ViajeController viaje = new ViajeController();

	TuristaDTO turista = null;
	GuiaDTO guia = null;
	GuiaDTO guia2 = null;
	GuiaDTO guia3 = null;
	ViajeDTO miViaje = null;
	ViajeDTO otroViaje = null;

	// Crear Turista
	{
		String nombreTurista = "Federico";
		String apellidoTurista = "Torcini";
		String mailTurista = "mail";
		String contraseñaTurista = "contra";
		String sexoTurista = Usuario.MASCULINO;
		int dniTurista = 42496679;
		int telefonoTurista = 1167254331;
		String medioLoginTurista = UsuarioController.MEDIO_LOGIN_MAIL;
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
		guia = usuario.RegistrarGuia(medioLoginGuia, nombreGuia, apellidoGuia, mailGuia, contraseñaGuia, sexoGuia, dniGuia, telefonoGuia, "Chile", "Santiago de Chile"); // Guia Buenos Aires | Argentina registrado exitosamente
	}

	// Crear Guia #2
	{
		String nombreGuia = "Otro";
		String apellidoGuia = "Guia";
		String mailGuia = "oguia@uade.edu.ar";
		String contraseñaGuia = "654321";
		String sexoGuia = Usuario.MASCULINO;
		int dniGuia = 36816684;
		int telefonoGuia = 11658469;
		String medioLoginGuia = UsuarioController.MEDIO_LOGIN_MAIL;
		guia2 = usuario.RegistrarGuia(medioLoginGuia, nombreGuia, apellidoGuia, mailGuia, contraseñaGuia, sexoGuia, dniGuia, telefonoGuia, "Argentina", "Buenos Aires"); // Guia Buenos Aires | Argentina registrado exitosamente

		usuario.AgregarServicio(new ServicioDTO(ServicioDTO.TOUR_INDIVIDUAL, 100), guia2);
	}

	// Crear Guia #3
	{
		String nombreGuia = "OtroMas";
		String apellidoGuia = "Guia";
		String mailGuia = "omguia@uade.edu.ar";
		String contraseñaGuia = "654321";
		String sexoGuia = Usuario.MASCULINO;
		int dniGuia = 36816684;
		int telefonoGuia = 11658469;
		String medioLoginGuia = UsuarioController.MEDIO_LOGIN_MAIL;
		guia3 = usuario.RegistrarGuia(medioLoginGuia, nombreGuia, apellidoGuia, mailGuia, contraseñaGuia, sexoGuia, dniGuia, telefonoGuia, "Holanda", "Amsterdam"); // Guia Buenos Aires | Argentina registrado exitosamente

		usuario.AgregarIdioma(GuiaDTO.IDIOMA_HOLANDES, guia3);
		usuario.AgregarServicio(new ServicioDTO(ServicioDTO.TOUR_GRUPAL, 100), guia3);
		usuario.AgregarServicio(new ServicioDTO(ServicioDTO.TRADUCCIONES, 300), guia3);
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
		miViaje = viaje.CrearViaje(turista, guia);
		viaje.Reservar(miViaje); // Viaje reservado con exito.

		// Reseña
		{
			ReseñaDTO reseña = new ReseñaDTO();
			reseña.SetEstrellas(4.2f);
			reseña.SetGuia(guia.GetId());
			reseña.SetTexto("Muy buen viaje, gracias!!!");
			reseña.SetViaje(miViaje.GetId());
			reseña.SetTurista(turista.GetId());
			viaje.AgregarReseña(reseña);
		}

		viaje.EnviarMensaje(miViaje, /*new TuristaDTO(),*/ "Hola como estas?");
		viaje.EnviarMensaje(miViaje, /*new GuiaDTO(null),*/ "Yo bien y vos?");
	}

	// Viaje #2
	{
		otroViaje = viaje.CrearViaje(turista, guia3);
		viaje.Reservar(otroViaje); // Viaje reservado con exito.

		// Reseña
		{
			ReseñaDTO reseña = new ReseñaDTO();
			reseña.SetEstrellas(3.2f);
			reseña.SetGuia(guia3.GetId());
			reseña.SetTexto("Otro muy buen viaje, gracias!!!");
			reseña.SetViaje(otroViaje.GetId());
			reseña.SetTurista(turista.GetId());
			viaje.AgregarReseña(reseña);
		}

		viaje.EnviarMensaje(otroViaje, /*new TuristaDTO(),*/ "Otro hola como estas?");
		viaje.EnviarMensaje(otroViaje, /*new GuiaDTO(null),*/ "otro yo bien y vos?");
	}

	Principal GUI = new Principal();
}

}
