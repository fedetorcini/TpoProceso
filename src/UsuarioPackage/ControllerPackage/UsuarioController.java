package src.UsuarioPackage.ControllerPackage;

import java.util.ArrayList;

import src.UsuarioPackage.Guia;
import src.UsuarioPackage.LoginPackage.*;
import src.UsuarioPackage.Turista;
import src.ViajePackage.Controller.ReseñaDTO;
import src.ViajePackage.Reseña;
import src.ViajePackage.ServicioPackage.Servicio;
import src.ViajePackage.ServicioPackage.ServicioDTO;

public class UsuarioController {

	public static final String MEDIO_LOGIN_APPLE = "Apple";
	public static final String MEDIO_LOGIN_MAIL = "Mail";
	public static final String MEDIO_LOGIN_GOOGLE= "Google";
	public static final String MEDIO_LOGIN_FACEBOOK = "Facebook";

	private static TuristaDTO loggedTurista = null;
	private static GuiaDTO loggedGuia = null;


	public static ArrayList<GuiaDTO> GetGuia (FiltroGuia filter) {
		if (filter != null)
		{
			ArrayList<GuiaDTO> filtrado = new ArrayList<>();
			for (GuiaDTO guia : Guia.GetGuiasDTO())
			{
				if (filter.Validar(guia))
					filtrado.add(guia);
			}
			return filtrado;
		}
		else
		{
			return Guia.GetGuiasDTO();
		}
	}

	public TuristaDTO  RegistrarTurista(String medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
		Turista turista = new Turista();
		turista.RegistrarTurista(StringToMedioLogin(medioLogin), nombre, apellido, mail, contraseña, sexo, dni, telefono); // Turista Federico Torcini no a podido ser registrado.
		return new TuristaDTO(turista);
	}

	public GuiaDTO RegistrarGuia(String medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
		Guia guia = new Guia();
		guia.RegistrarGuia(StringToMedioLogin(medioLogin), nombre, apellido, mail, contraseña, sexo, dni, telefono, pais, ciudad); // Turista Federico Torcini no a podido ser registrado.
		return new GuiaDTO(guia);
	}

	public TuristaDTO LoginTurista(String email, String contraseña) {

		TuristaDTO output = null;

		Turista turista = new Turista();
		if (turista.GetPorMail(email))
		{
			if (turista.Login(email, contraseña)) {
				output = turista.ToDTO();
			}
		}

		loggedTurista = output;
		return output;
	}

	public GuiaDTO LoginGuia(String email, String contraseña) {
		Guia guia = new Guia();
		guia.GetPorMail(email);
		boolean success = guia.Login(email, contraseña);

		GuiaDTO dto = null;
		if (success)
		{
			dto = guia.ToDTO();
		}

		loggedGuia = dto;
		return dto;
	}

	private IMedioLogin StringToMedioLogin(String medioLogin) {

		switch(medioLogin)
		{
			case MEDIO_LOGIN_FACEBOOK:
				return new Facebook();
			case MEDIO_LOGIN_GOOGLE:
				return new Google();
			case MEDIO_LOGIN_APPLE :
				return new Apple();
			case MEDIO_LOGIN_MAIL:
			default:
				return new Mail();
		}
	}

	public static TuristaDTO GetLoggedTurista() { return loggedTurista; }

	public static GuiaDTO GetLoggedGuia() { return loggedGuia; }

	public static void LogOut() {
		loggedTurista = null;
		loggedGuia = null;
	}

	public TuristaDTO UpdateTurista(String nombre, String apellido, String sexo, int telefono, int dni) {

		Turista turista = new Turista();
		turista.GetPorDTO(loggedTurista);
		turista.ActualizarPerfil(nombre, apellido, sexo, telefono, dni);
		turista.SetNombre(nombre);
		turista.SetApellido(apellido);
		turista.SetSexo(sexo);
		turista.SetTelefono(telefono);
		turista.SetDni(dni);

		loggedTurista = turista.ToDTO();

		return loggedTurista;
	}

	public void AgregarServicio(ServicioDTO servicioDTO, GuiaDTO guiaDto) {
		Guia guia = new Guia();
		guia.GetPorDTO(guiaDto);

		guia.AgregarServicio(new Servicio(servicioDTO));
	}

	public void AgregarIdioma(String idioma, GuiaDTO guiaDto) {
		Guia guia = new Guia();
		guia.GetPorDTO(guiaDto);

		guia.AgregarIdioma(idioma);
	}


	public static ArrayList<ReseñaDTO> GetReseñasByGuia(GuiaDTO guiaDTO) {
		ArrayList<ReseñaDTO> reseñaDtos = new ArrayList<>();

		for (ReseñaDTO reseñaDto : Reseña.GetReseñasDTO()) {
			if (reseñaDto.GetGuia() == guiaDTO.GetId()) {
				reseñaDtos.add(reseñaDto);
			}
		}
		return reseñaDtos;
	}
}
