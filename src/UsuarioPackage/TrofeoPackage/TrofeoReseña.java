package src.UsuarioPackage.TrofeoPackage;

import java.util.HashMap;

import src.NotificadorPackage.Mensaje;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.TrofeoPackage.ControllerPackage.TrofeoDTO;

public class TrofeoReseña extends Trofeo<Turista>{

private static HashMap<Integer, TrofeoReseña> trofeos = new HashMap<>();
private HashMap<Turista, Integer> reseñasPorUsuario;
private int reseñasNecesarias;

public TrofeoReseña() {
}

public void RegistrarTrofeo(int reseñasNecesarias) {
	this.reseñasPorUsuario = new HashMap<Turista, Integer>();
	this.reseñasNecesarias = reseñasNecesarias;
	this.trofeoId = IDs;
	IDs++;

	trofeos.put(this.trofeoId, this);
}

public void Notificar(Turista object) {
	int nuevaCuenta = 1;
	if (reseñasPorUsuario.containsKey(object))
	{
		nuevaCuenta = reseñasPorUsuario.get(object) + 1;
	}
	
	reseñasPorUsuario.put(object, nuevaCuenta);
	if (this.reseñasNecesarias <= reseñasPorUsuario.get(object))
	{
		Publicar(new Mensaje("Has Recibido un nuevo trofeo!!! Gracias por realizar " + reseñasNecesarias + ". con tu feedback podemos mejorar como empresa."));
	}
}

public boolean GetPorDTO(TrofeoDTO trofeoDTO) {

	boolean encontrado = false;
	for (TrofeoReseña trofeo : trofeos.values())
	{
		if (trofeo.trofeoId == trofeoDTO.GetID())
		{
			this.reseñasNecesarias = trofeo.reseñasNecesarias;
			this.reseñasPorUsuario = trofeo.reseñasPorUsuario;
			this.trofeoId = trofeo.trofeoId;
			encontrado = true;
		}
	}
	return encontrado;
}

}
