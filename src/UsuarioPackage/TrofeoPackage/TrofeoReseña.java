package src.UsuarioPackage.TrofeoPackage;

import java.util.HashMap;

import src.NotificadorPackage.Mensaje;
import src.UsuarioPackage.Turista;

public class TrofeoReseña extends Trofeo<Turista>{

private HashMap<Turista, Integer> reseñasPorUsuario;
private int reseñasNecesarias;

protected TrofeoReseña(int reseñasNecesarias)
{
	reseñasPorUsuario = new HashMap<Turista, Integer>();
}

private int GetReseñasNecesarias() {
	return reseñasNecesarias;
}

private void SetReseñasNecesarias(int reseñasNecesarias) {
	this.reseñasNecesarias = reseñasNecesarias;
}

public static TrofeoReseña RegistrarTrofeo(int reseñasNecesarias)
{
	TrofeoReseña myTrofeo = new TrofeoReseña(reseñasNecesarias);
	myTrofeo.SetReseñasNecesarias(reseñasNecesarias);
	myTrofeo.SetTrofeoId(IDs);
	IDs++;
	
	System.out.println("Trofeo con id " + myTrofeo.GetTrofeoId() + " y reseñas necesarias " + reseñasNecesarias + " fue creado exitosamente.");
	return myTrofeo;
}

public void Notificar(Turista object) 
{
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

}
