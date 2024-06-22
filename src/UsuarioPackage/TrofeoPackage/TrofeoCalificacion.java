package src.UsuarioPackage.TrofeoPackage;

import src.UsuarioPackage.Guia;

public class TrofeoCalificacion extends Trofeo<Guia>{

private int calificacionNecesaria;

protected TrofeoCalificacion(int calificacionNecesaria)
{
	this.calificacionNecesaria = calificacionNecesaria;
}

private int GetCalificacionNecesaria() {
	return calificacionNecesaria;
}

private void SetCalificacionNecesaria(int calificacionNecesaria) {
	this.calificacionNecesaria = calificacionNecesaria;
}

public static TrofeoCalificacion RegistrarTrofeo(int calificacionNecesaria)
{
	TrofeoCalificacion myTrofeo = new TrofeoCalificacion(calificacionNecesaria);
	myTrofeo.SetCalificacionNecesaria(calificacionNecesaria);
	myTrofeo.SetTrofeoId(IDs);
	IDs++;
	
	System.out.println("Trofeo con id " + myTrofeo.GetTrofeoId() + " y calificacion necesaria " + calificacionNecesaria + " fue creado exitosamente.");
	return myTrofeo;
}

public void Notificar(Guia object) 
{
	if (object.GetPromedio() >= calificacionNecesaria)
	{
		Publicar("Felicidades tu calificacion promedio es de " + object.GetPromedio() + ". Continua el gran trabajo.");
	}
}

}
