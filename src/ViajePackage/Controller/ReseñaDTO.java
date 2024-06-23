package src.ViajePackage.Controller;

import src.Reseña;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;

public class ReseñaDTO {
private String texto;
private float estrellas;
private TuristaDTO turista;
private GuiaDTO guia;
private ViajeDTO viaje;

public ReseñaDTO(Reseña reseña) {}
	
public ReseñaDTO() {}

public String GetTexto() {
	return texto;
}

public void SetTexto(String texto) {
	this.texto = texto;
}

public float GetEstrellas() {
	return estrellas;
}

public void SetEstrellas(float estrellas) {
	this.estrellas = estrellas;
}

public TuristaDTO GetTurista() {
	return turista;
}

public void SetTurista(TuristaDTO turista) {
	this.turista = turista;
}

public GuiaDTO GetGuia() {
	return guia;
}

public void SetGuia(GuiaDTO guia) {
	this.guia = guia;
}

public ViajeDTO GetViaje() {
	return viaje;
}

public void SetViaje(ViajeDTO viaje) {
	this.viaje = viaje;
}

}
