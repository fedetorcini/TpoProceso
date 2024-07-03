package src.ViajePackage.Controller;

import java.util.ArrayList;

import src.UsuarioPackage.Guia;
import src.ViajePackage.Viaje;

public class ViajeDTO {

	private int id;
	private int guiaId;
	private int turistaId;
	private double abonado;
	private String estadoViaje;
	public ArrayList<MensajeDTO> chat;

	public ViajeDTO(Viaje viaje) {
		this.id = viaje.GetId();
		this.guiaId = viaje.GetGuiaId();
		this.turistaId = viaje.GetTuristaId();
		this.estadoViaje = viaje.GetEstadoViaje();
		this.chat = viaje.GetMensajes();
		this.abonado = viaje.GetMontoAbonado();
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

	public double GetAbonado() { return abonado;}
}
