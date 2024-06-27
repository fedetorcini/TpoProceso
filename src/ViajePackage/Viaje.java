package src.ViajePackage;

import java.util.ArrayList;
import java.util.HashMap;

import src.NotificadorPackage.Mensaje;
import src.ReservaPackage.Reserva;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.ViajePackage.Controller.MensajeDTO;
import src.ViajePackage.Controller.ViajeDTO;

public class Viaje {

	private static HashMap<Integer, Viaje> viajes = new HashMap<Integer, Viaje>();
	private static int IDs = 0;
	private int id;
	private Reserva reserva;
	private int guiaId;
	private int turistaId;
	private double costoTotal;
	private double penalidad;
	private IEstadoViaje estadoViaje;
	private Reseña reseña;
	private Chat chat;

	public static ArrayList<ViajeDTO> GetViajes() {
		ArrayList<ViajeDTO> viajesDtos = new ArrayList<>();

		for(Viaje viaje : viajes.values()){
			viajesDtos.add(new ViajeDTO(viaje));
		}

		return viajesDtos;
	}

	public Viaje() {
		id = -1;
		guiaId = -1;
		turistaId = -1;
		costoTotal = -1;
		penalidad = 0;
		reserva = new Reserva();
		estadoViaje = new Reservado();
		chat = new Chat(turistaId, guiaId);
		reseña = new Reseña();
	}

	public void ResgistrarReserva(Reserva reserva) {}

	public double CalcularPenalidad() {
		return penalidad;
	}

	public void CambiarEstado(IEstadoViaje estado) {
		this.estadoViaje = estado;
	}

	public void RegistrarReseña(String descripcion, float calificacion) {
		Reseña reseña = new Reseña();
		reseña.RegistrarReseña(descripcion, turistaId, guiaId, 0, calificacion);

		Guia guia = new Guia();
		guia.GetPorId(guia.GetId());
		guia.AgregarReseña(reseña);
	}

	public Viaje CrearViaje(Turista turista, Guia guia) {
		this.turistaId = turista.GetId();
		this.guiaId = guia.GetId();
		this.id = IDs;
		IDs++;

		chat = new Chat(turistaId, guiaId);
		chat.Suscribir(turista.GetNotificador());
		chat.Suscribir(guia.GetNotificador());

		viajes.put(id, this);

		System.out.println("Viaje creado con exito");
		return this;
	}

	public void Reservar() {
		System.out.println("Viaje reservado con exito.");
		CambiarEstado(new Reservado());
		viajes.put(GetId(), this);
	}

	public void Pagar() {
		estadoViaje.Confirmar(this);
	}

	public void PublicarAlChatDeViaje(Mensaje mensaje) {
		chat.EnviarMensaje(mensaje);
	}

	public boolean GetPorDTO(ViajeDTO dto) { return GetPorId(dto.GetId());}

	public boolean GetPorId(int id) {

		boolean encontrado = false;
		for (Viaje viaje : viajes.values()) {
			if (viaje.id == id) {
				this.turistaId = viaje.turistaId;
				this.guiaId = viaje.guiaId;
				this.id = viaje.id;
				this.estadoViaje = viaje.estadoViaje;
				this.reserva = viaje.reserva;
				this.chat = viaje.chat;
				encontrado = true;
			}
		}
		return encontrado;
	}

	public Reseña GetReseña() {
		return reseña;
	}

	public ArrayList<MensajeDTO> GetMensajes() {return chat.GetMensajes();}

	public int GetId() {
			return id;
	}

	public double GetCosto() {
		return costoTotal;
	}

	public double GetPenalidad(){ return penalidad;}

	public String GetEstadoReserva() {
		return reserva.toString();
	}

	public String GetEstadoViaje() {
		return estadoViaje.toString();
	}

	public int GetTuristaId(){
		return turistaId;
	}

	public int GetGuiaId(){
		return guiaId;
	}
}
