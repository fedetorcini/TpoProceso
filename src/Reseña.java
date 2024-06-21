package src;

import java.util.HashMap;

import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;

public class Reseña {

private static HashMap<String, Reseña> reseñas = new HashMap<String, Reseña>();
private String texto;
private int estrellas;
private Turista turista;
private Guia guia;

private String GetTexto() {
	return texto;
}

private void SetTexto(String texto) {
	this.texto = texto;
}

private int GetEstrellas() {
	return estrellas;
}

private void SetEstrellas(int estrellas) {
	this.estrellas = estrellas;
}

private Turista GetTurista() {
	return turista;
}

private void SetTurista(Turista turista) {
	this.turista = turista;
}

private Guia GetGuia() {
	return guia;
}

private void SetGuia(Guia guia) {
	this.guia = guia;
}

public static Reseña RegistrarReseña(String mensaje, Turista turista, Guia guia, int estrellas)
{
	Reseña miReseña = new Reseña();
	reseñas.put(ObtenerKeyDeGuiaTurista(turista, guia), miReseña);
	miReseña.SetEstrellas(estrellas);
	miReseña.SetTurista(turista);
	miReseña.SetGuia(guia);
	miReseña.SetTexto(mensaje);
	
	System.out.println("Reseña : " + mensaje + ". Creada con exito!");
	return miReseña;
}

private static String ObtenerKeyDeGuiaTurista(Turista turista, Guia guia)
{
	return turista.toString() + guia.toString();		
}

}
