package src.UsuarioPackage.ControllerPackage;

import java.util.ArrayList;

import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.LoginPackage.IMedioLogin;

public class UsuarioController {

public ArrayList<GuiaDTO> GetGuia(FiltroGuia filter) {
	if (filter != null)
	{		
		ArrayList<GuiaDTO> filtrado = new ArrayList<GuiaDTO>();
		for (GuiaDTO guia : Guia.GetGuiasDTO())
		{
			filter.Validar(guia);
			filtrado.add(guia);
		}
		return null;
	}
	else
	{		
		return Guia.GetGuiasDTO();
	}
}

public TuristaDTO RegistrarTurista(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
	Turista turista = new Turista();
	turista.RegistrarTurista(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono); // Turista Federico Torcini no a podido ser registrado.	
	return new TuristaDTO(turista);
}

public GuiaDTO RegistrarGuia(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono, String pais, String ciudad) {
	Guia guia = new Guia();
	guia.RegistrarGuia(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono, pais, ciudad); // Turista Federico Torcini no a podido ser registrado.	
	return new GuiaDTO(guia);
}

public TuristaDTO LoginTurista(String email, String contraseña) {
	Turista turista = new Turista();
	turista.GetPorMail(email);
	boolean success = turista.Login(email, contraseña);
	
	TuristaDTO dto = null;	
	if (success) {
		dto = turista.ToDTO();
	}
	return dto;
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
	return dto;
}

}
