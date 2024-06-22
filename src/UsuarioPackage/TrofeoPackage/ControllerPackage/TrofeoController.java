package src.UsuarioPackage.TrofeoPackage.ControllerPackage;

import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.TrofeoPackage.TrofeoCalificacion;
import src.UsuarioPackage.TrofeoPackage.TrofeoReseña;

public class TrofeoController {

	public void RegistrarTrofeoCalificacion(float calificacionNecesaria) {
		TrofeoCalificacion trofeo = new TrofeoCalificacion(); 
		trofeo.RegistrarTrofeo(calificacionNecesaria); // Trofeo con id n y reseñas necesarias reseñasNecesarias fue creado exitosamente.		
	}
	
	public TrofeoDTO RegistrarTrofeoReseña(int reseñasNecesarias) {
		TrofeoReseña trofeo = new TrofeoReseña(); 
		trofeo.RegistrarTrofeo(reseñasNecesarias); // Trofeo con id n y reseñas necesarias reseñasNecesarias fue creado exitosamente.		
		return new TrofeoDTO();
	}

	public void Suscribir(TrofeoDTO trofeoDTO, TuristaDTO turistaDTO) {
		Turista turista = new Turista();
		turista.GetPorDTO(turistaDTO);
		
		TrofeoReseña trofeo = new TrofeoReseña();
		trofeo.GetPorDTO(trofeoDTO);
		
		turista.Suscribir(trofeo);
	}

	public void Suscribir(TrofeoDTO trofeoDTO, GuiaDTO guiaDTO) {
		Guia guia = new Guia();
		guia.GetPorDTO(guiaDTO);
		
		TrofeoCalificacion trofeo = new TrofeoCalificacion();
		trofeo.GetPorDTO(trofeoDTO);
		
		guia.Suscribir(trofeo);
	}



}
