package src.UsuarioPackage.TrofeoPackage;

import java.util.HashMap;

import src.NotificadorPackage.Mensaje;
import src.UsuarioPackage.Turista;

public class TrofeoReseña extends Trofeo<Turista>{

	private static TrofeoReseña instance = new TrofeoReseña();
	private static HashMap<Turista, Integer> reseñasPorUsuario = new HashMap<>();
	private static int reseñasNecesarias = 1;

	public static TrofeoReseña GetInstancia() { return instance; }

	private TrofeoReseña() {}

	public void Notificar(Turista object) {
		int nuevaCuenta = 1;
		if (reseñasPorUsuario.containsKey(object))
		{
			nuevaCuenta = reseñasPorUsuario.get(object) + 1;
		}

		reseñasPorUsuario.put(object, nuevaCuenta);
		if (this.reseñasNecesarias <= reseñasPorUsuario.get(object))
		{
			Publicar(new Mensaje("Turista " + object + " a resibido un trofeo por su cantidad de reseñas!!!!"));
		}
	}

}
