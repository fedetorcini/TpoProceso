package src.Usuario;

import java.util.HashMap;

public class Trofeo implements IObservador{

	private static int IDs = 0;
	private HashMap<Observable, Integer> reseñasPorUsuario;
	private int trofeoId;
	private int reseñasNecesarias;
	
	private int GetTrofeoId() {
		return trofeoId;
	}

	private void SetTrofeoId(int trofeoId) {
		this.trofeoId = trofeoId;
	}

	private int GetReseñasNecesarias() {
		return reseñasNecesarias;
	}

	private void SetReseñasNecesarias(int reseñasNecesarias) {
		this.reseñasNecesarias = reseñasNecesarias;
	}
	
	private Trofeo()
	{
		reseñasPorUsuario = new HashMap<Observable, Integer>();
	}
	
	public static Trofeo RegistrarTrofeo(int reseñasNecesarias)
	{
		Trofeo myTrofeo = new Trofeo();
		myTrofeo.SetReseñasNecesarias(reseñasNecesarias);
		myTrofeo.SetTrofeoId(IDs);
		IDs++;
		
		System.out.println("Trofeo con id " + myTrofeo.GetTrofeoId() + " y reseñas necesarias " + reseñasNecesarias + " fue creado exitosamente.");
		return myTrofeo;
	}
	
	public void notificar(Observable usuario) 
	{
		reseñasPorUsuario.get(usuario);
	}

}
