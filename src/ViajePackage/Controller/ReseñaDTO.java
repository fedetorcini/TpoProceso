package src.ViajePackage.Controller;

import src.ViajePackage.Reseña;

public class ReseñaDTO {

	private String texto;
	private float estrellas;
	private int turistaId;
	private int guiaId;
	private int viajeId;

	public ReseñaDTO(Reseña reseña) {
		this.texto = reseña.GetTexto();
		this.estrellas = reseña.GetCalificacion();
		this.turistaId = reseña.GetTuristaId();
		this.guiaId = reseña.GetGuiaId();
		this.viajeId = reseña.GetViajeId();
	}

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

	public int GetTurista() {
		return turistaId;
	}

	public void SetTurista(int turista) {
		this.turistaId = turista;
	}

	public int GetGuia() {
		return guiaId;
	}

	public void SetGuia(int guia) {
		this.guiaId = guia;
	}

	public int GetViaje() {
		return viajeId;
	}

	public void SetViaje(int viaje) {
		this.viajeId = viaje;
	}

}
