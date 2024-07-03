package src.UsuarioPackage.TrofeoPackage;

import src.NotificadorPackage.Mensaje;
import src.UsuarioPackage.Guia;

public class TrofeoCalificacion extends Trofeo<Guia>{

	private static TrofeoCalificacion instacia = new TrofeoCalificacion();
	private static float calificacionNecesaria = 1;

	private TrofeoCalificacion(){}

	public static TrofeoCalificacion GetInstancia() { return instacia;}

	public void Notificar(Guia object) {
		if (object.GetPromedio() >= calificacionNecesaria)
		{
			Publicar(new Mensaje("Guia " + object.GetNombre() + " " + object.GetApellido() + " a resibido un trofeo por su calificacion promedio de : " + object.GetPromedio() + "."));
		}
	}
}
