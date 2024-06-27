package src.ViajePackage;

import java.util.ArrayList;
import java.util.HashMap;

import src.ViajePackage.Controller.ReseñaDTO;

public class Reseña {

	private static HashMap<String, Reseña> reseñas = new HashMap<>();
	private String texto;
	private float estrellas;
	private int turistaId;
	private int guiaId;
	private int viajeId;

	public String GetTexto() {
		return texto;
	}

	private void SetTexto(String texto) {
		this.texto = texto;
	}

	private float GetEstrellas() {
		return estrellas;
	}

	private void SetEstrellas(float calificacion) {
		this.estrellas = calificacion;
	}

	public Reseña RegistrarReseña(String mensaje, int turistaId, int guiaId, int viajeId, float calificacion) {
		reseñas.put(ObtenerKeyDeGuiaTurista(turistaId, guiaId), this);
		this.estrellas = calificacion;
		this.turistaId = turistaId;
		this.guiaId = guiaId;
		this.viajeId = viajeId;
		this.texto = mensaje;

		System.out.println("Reseña : " + mensaje + ". Creada con exito!");
		return this;
	}

	private static String ObtenerKeyDeGuiaTurista(Integer turista, Integer guia) {
		return turista.toString() + guia.toString();
	}

	public Float GetCalificacion() {
		return estrellas;
	}

	public void RegistrarReseña(ReseñaDTO reseñaDto) {
		RegistrarReseña(reseñaDto.GetTexto(), reseñaDto.GetTurista(), reseñaDto.GetGuia(), reseñaDto.GetViaje(), reseñaDto.GetEstrellas());
	}

	public int GetViajeId() {
		return viajeId;
	}

	public int GetGuiaId () {
		return guiaId;
	}

	public int GetTuristaId() { return turistaId; }

	public static ArrayList<ReseñaDTO> GetReseñasDTO() {
		ArrayList<ReseñaDTO> reseñasDtos = new ArrayList<>();

		for (Reseña reseña : reseñas.values()){
			reseñasDtos.add(new ReseñaDTO(reseña));
		}
		return reseñasDtos;
	}

}
