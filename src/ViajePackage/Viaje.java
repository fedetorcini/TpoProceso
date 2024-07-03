package src.ViajePackage;

import java.util.ArrayList;
import java.util.HashMap;

import src.NotificadorPackage.Mensaje;
import src.ObserverPackage.Observable;
import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.ViajePackage.Chat.Chat;
import src.ViajePackage.Controller.MensajeDTO;
import src.ViajePackage.Controller.ViajeDTO;
import src.ViajePackage.Estado.IEstadoViaje;
import src.ViajePackage.Estado.Pendiente;
import src.ViajePackage.Estado.Reservado;

public class Viaje extends Observable<Mensaje> {

	private static HashMap<Integer, Viaje> viajes = new HashMap<Integer, Viaje>();
	private static int IDs = 0;
	private int id;
	private int guiaId;
	private int turistaId;
	private double penalidad;
	private IEstadoViaje estadoViaje;
	private Chat chat;
	private ArrayList<Pago> pagos;

	// Create Save Load -----------------------------------------------------------
	public Viaje() {
		id = -1;
		guiaId = -1;
		turistaId = -1;
		penalidad = 0;
		estadoViaje = new Pendiente();
		chat = new Chat(turistaId, guiaId);
		pagos = new ArrayList<>();
	}

	public Viaje CrearViaje(Turista turista, Guia guia) {
		this.turistaId = turista.GetId();
		this.guiaId = guia.GetId();
		this.id = IDs;
		IDs++;

		chat = new Chat(turistaId, guiaId);
		chat.Suscribir(turista.GetNotificador());
		chat.Suscribir(guia.GetNotificador());

		this.Suscribir(turista.GetNotificador());
		this.Suscribir(guia.GetNotificador());
		this.GuardarEnDB();

		return this;
	}

	private void GuardarEnDB() { viajes.put(id, this);}

	public boolean GetPorDTO(ViajeDTO dto) { return GetPorId(dto.GetId());}

	public boolean GetPorId(int id) {

		boolean encontrado = false;
		for (Viaje viaje : viajes.values()) {
			if (viaje.id == id) {
				this.turistaId = viaje.turistaId;
				this.guiaId = viaje.guiaId;
				this.id = viaje.id;
				this.estadoViaje = viaje.estadoViaje;
				this.chat = viaje.chat;
				this.pagos = viaje.pagos;
				encontrado = true;
			}
		}
		return encontrado;
	}

	// Chat -----------------------------------------------------------
	public void PublicarAlChatDeViaje(Mensaje mensaje) {chat.EnviarMensaje(mensaje);}

	// Estados -----------------------------------------------------------
	public void CambiarEstado(IEstadoViaje estado) {
		this.estadoViaje = estado;
	}

	public String GetEstadoViaje() {
		return estadoViaje.toString();
	}

	public boolean Aceptar() {
		Mensaje mensaje = new Mensaje("");
		boolean success = estadoViaje.Aceptar(this, mensaje);
		if(success){
			GuardarEnDB();
			Publicar(mensaje);
		}
		return success;
	}

	public boolean Reservar() {
		Mensaje mensaje = new Mensaje("");
		boolean success = estadoViaje.Reservar(this, mensaje);
		if(success){
			GuardarEnDB();
			Publicar(mensaje);
		}
		return success;
	}

	public boolean Finalizar() {
		Mensaje mensaje = new Mensaje("");
		boolean success = estadoViaje.Finalizar(this, mensaje);
		if(success){
			GuardarEnDB();
			Publicar(mensaje);
		}
		return success;
	}

	public boolean Rechazar() {
		Mensaje mensaje = new Mensaje("");
		boolean success = estadoViaje.Rechazar(this, mensaje);
		if(success){
			GuardarEnDB();
			Publicar(mensaje);
		}
		return success;
	}

	public boolean Pagar(PagoDTO pagoDto) {
		Mensaje mensaje = new Mensaje("");
		boolean success = estadoViaje.Pagar(this, pagoDto, mensaje);
		if (success){
			GuardarEnDB();
			Publicar(mensaje);
		}
		return success;
	}

	// Getters -----------------------------------------------------------
	public int GetTuristaId(){
		return turistaId;
	}

	public int GetGuiaId(){
		return guiaId;
	}

	public ArrayList<Pago> GetPagos() { return pagos; }

	public double GetMinimo() {
		Guia guia = new Guia();
		guia.GetPorId(guiaId);
		return guia.GetPagoMinimo();
	}

	public double GetCostoTotal() {
		Guia guia = new Guia();
		guia.GetPorId(guiaId);
		return guia.GetPrecioTotal();
	}

	public double GetPenalidad() { return penalidad * GetCostoTotal();}

	public static ArrayList<ViajeDTO> GetViajes() {
		ArrayList<ViajeDTO> viajesDtos = new ArrayList<>();

		for(Viaje viaje : viajes.values()){
			viajesDtos.add(new ViajeDTO(viaje));
		}

		return viajesDtos;
	}

	public ArrayList<MensajeDTO> GetMensajes() { return chat.GetMensajes(); }

	public int GetId() {return id;}

	public double GetMontoAbonado() {
		double abonado = 0;
		for (Pago pago : pagos){
			abonado += pago.GetMonto();
		}
		return abonado;
	}

/*
	public void Reservar() {
		CambiarEstado(new Reservado());

		Turista turista = new Turista();
		turista.GetPorId(turistaId);

		Guia guia = new Guia();
		guia.GetPorId(guiaId);

		this.Suscribir(turista.GetNotificador());
		this.Suscribir(guia.GetNotificador());

		this.costoTotal = guia.GetPrecioTotal();

		viajes.put(GetId(), this);
	}

	public void Pagar(PagoDTO pagoDto) {
		ArrayList<PagoDTO> pagosDtos = Pago.GetPagosDeViaje(id);
		double montoPagado = 0;

		for (PagoDTO pago : pagosDtos){
			montoPagado += pago.getMonto();
		}

		if (montoPagado >= costoTotal){
			estadoViaje.Confirmar(this);
		}

		viajes.put(id, this);
	}
*/

}
