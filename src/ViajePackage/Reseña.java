package src.ViajePackage;

import java.util.ArrayList;
import java.util.HashMap;

import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
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

	public Reseña RegistrarReseña(Turista turista, Guia guia, Viaje viaje) {
		return RegistrarReseña(turista.GetId(), guia.GetId(), viaje.GetId());
	}

	public Reseña RegistrarReseña(ReseñaDTO reseñaDto) {
		this.texto = reseñaDto.GetTexto();
		this.estrellas = reseñaDto.GetEstrellas();
		return RegistrarReseña(reseñaDto.GetTurista(), reseñaDto.GetGuia(), reseñaDto.GetViaje());
	}

	private Reseña RegistrarReseña(int turistaId, int guiaId, int viajeId) {
		reseñas.put(ObtenerKeyDeGuiaTurista(turistaId, guiaId), this);
		this.turistaId = turistaId;
		this.guiaId = guiaId;
		this.viajeId = viajeId;
		return this;
	}

	private static String ObtenerKeyDeGuiaTurista(Integer turista, Integer guia) {
		return turista.toString() + guia.toString();
	}

	public Float GetCalificacion() {
		return estrellas;
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
	@Override
	public String toString(){
		return "ViajeId : " + viajeId + " | GuiaId : " + guiaId;
	}

}
