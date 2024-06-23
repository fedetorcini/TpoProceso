package src.UsuarioPackage.TrofeoPackage;

import java.util.HashMap;

import src.NotificadorPackage.Mensaje;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.TrofeoPackage.ControllerPackage.TrofeoDTO;

public class TrofeoCalificacion extends Trofeo<Guia>{

private HashMap<Integer, TrofeoCalificacion> trofeos = new HashMap<Integer, TrofeoCalificacion>();
private float calificacionNecesaria;

public void RegistrarTrofeo(float calificacionNecesaria)
{
	this.calificacionNecesaria = calificacionNecesaria;
	this.trofeoId = IDs;
	IDs++;
	
	trofeos.put(this.trofeoId, this);
}

public void Notificar(Guia object) 
{
	if (object.GetPromedio() >= calificacionNecesaria)
	{
		Publicar(new Mensaje("Has Recibido un nuevo trofeo!!! Felicidades tu calificacion promedio es de " + object.GetPromedio() + ". Continua el gran trabajo."));
	}
}

public boolean GetPorDTO(TrofeoDTO trofeoDTO) {

	boolean encontrado = false;
	for (TrofeoCalificacion trofeo : trofeos.values())
	{
		if (trofeo.trofeoId == trofeoDTO.GetID())
		{
			this.calificacionNecesaria = trofeo.calificacionNecesaria;
			this.trofeoId = trofeo.trofeoId;
			encontrado = true;
		}
	}
	return encontrado;
}
}
