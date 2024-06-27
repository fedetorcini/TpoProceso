package src.ViajePackage.Controller;

import java.util.ArrayList;

import src.UsuarioPackage.ControllerPackage.FiltroGuia;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.UsuarioPackage.Guia;
import src.ViajePackage.Viaje;

public class ViajeDTO {

	private int id;
	private String estadoReserva;
	private int guiaId;
	private int turistaId;
	private double penalidad;
	private String estadoViaje;
	private ReseñaDTO reseña;
	public ArrayList<MensajeDTO> chat;

	public ViajeDTO(Viaje viaje) {
		this.id = viaje.GetId();
		this.estadoReserva = viaje.GetEstadoReserva();
		this.guiaId = viaje.GetGuiaId();
		this.turistaId = viaje.GetTuristaId();
		this.penalidad = viaje.GetPenalidad();
		this.estadoViaje = viaje.GetEstadoViaje();
		this.reseña = new ReseñaDTO(viaje.GetReseña());
		this.chat = viaje.GetMensajes();
	}

	public int GetId() {
		return id;
	}

	public int GetTuristaId() {
		return turistaId;
	}

	public int GetGuiaId() { return guiaId; }

	public double GetPrecio() {
		Guia guia = new Guia();
		guia.GetPorId(guiaId);
		double precio = guia.GetPrecioTotal();
		return precio;
	}

	public String GetEstado() { return estadoViaje;}

	public String toString(){ return "Viaje ID : " + id; }
}
