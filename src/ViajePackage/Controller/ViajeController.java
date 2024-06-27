package src.ViajePackage.Controller;

import src.PagoPackage.Pago;
import src.PagoPackage.PagoDTO;
import src.ViajePackage.Reseña;
import src.NotificadorPackage.Mensaje;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.ViajePackage.Viaje;

import java.util.ArrayList;

public class ViajeController {

	public ViajeDTO CrearViaje(TuristaDTO turistaDTO, GuiaDTO guiaDTO) {
		Viaje viaje = new Viaje();

		Turista turista = new Turista();
		turista.GetPorDTO(turistaDTO);

		Guia guia = new Guia();
		guia.GetPorDTO(guiaDTO);

		viaje.CrearViaje(turista, guia);
		return new ViajeDTO(viaje);
	}

	public void Reservar(ViajeDTO viajeDTO) {
		Viaje viaje = new Viaje();
		viaje.GetPorDTO(viajeDTO);
		viaje.Reservar();

		Turista turista = new Turista();
		turista.GetPorId(viaje.GetTuristaId());

		Guia guia = new Guia();
		guia.GetPorId(viaje.GetGuiaId());

		turista.AgregarViaje(viaje);
		guia.AgregarViaje(viaje);

		Reseña reseña = new Reseña();
		reseña.RegistrarReseña(turista, guia, viaje);
	}

	public void DejarReseña(ReseñaDTO reseñaDto) {

		Reseña reseña = new Reseña();
		reseña.RegistrarReseña(reseñaDto);

		Viaje viaje = new Viaje();
		viaje.GetPorId(reseñaDto.GetViaje());

		Turista turista = new Turista();
		turista.GetPorId(viaje.GetTuristaId());

		Guia guia = new Guia();
		guia.GetPorId(viaje.GetGuiaId());

		turista.AgregarReseña(reseña);
		guia.AgregarReseña(reseña);
	}

	public void EnviarMensaje(TuristaDTO turista, ViajeDTO viajeDTO, String string) {
			Mensaje mensaje = new Mensaje(string);

			Turista emisor = new Turista();
			emisor.GetPorDTO(turista);
			mensaje.SetEmisor(emisor);

			Viaje viaje = new Viaje();
			viaje.GetPorDTO(viajeDTO);

			viaje.PublicarAlChatDeViaje(mensaje);
	}

	public void EnviarMensaje(GuiaDTO guia, ViajeDTO viajeDTO, String string) {
		Mensaje mensaje = new Mensaje(string);

		Guia emisor = new Guia();
		emisor.GetPorDTO(guia);
		mensaje.SetEmisor(emisor);

		Viaje viaje = new Viaje();
		viaje.GetPorDTO(viajeDTO);

		viaje.PublicarAlChatDeViaje(mensaje);
	}

	public ArrayList<ViajeDTO> GetViajesDeGuia(GuiaDTO filter) {
		if (filter != null)
		{
			ArrayList<ViajeDTO> filtrado = new ArrayList<>();
			for (ViajeDTO viaje : Viaje.GetViajes())
			{
				if (viaje.GetGuiaId() == filter.GetId()){
					filtrado.add(viaje);
				}
			}
			return filtrado;
		}
		else
		{
			return Viaje.GetViajes();
		}
	}

	public ArrayList<ViajeDTO> GetViajesDeTurista(TuristaDTO filter) {
		if (filter != null)
		{
			ArrayList<ViajeDTO> filtrado = new ArrayList<>();
			for (ViajeDTO viaje : Viaje.GetViajes())
			{
				if (viaje.GetTuristaId() == filter.GetId()){
					filtrado.add(viaje);
				}
			}
			return filtrado;
		}
		else
		{
			return Viaje.GetViajes();
		}
	}

	public ViajeDTO GetViajeById(int filter) {

		ArrayList<ViajeDTO> filtrado = new ArrayList<>();
		for (ViajeDTO viaje : Viaje.GetViajes())
		{
			if (viaje.GetId() == filter){
				return viaje;
			}
		}
		return null;
	}

	public ArrayList<MensajeDTO> GetChatDe(ViajeDTO dto) {
		Viaje viaje = new Viaje();
		viaje.GetPorDTO(dto);
		return viaje.GetMensajes();
	}

	public void Pagar(PagoDTO pagoDto) {
		Pago pago = new Pago();
		pago.RegistrarPago(pagoDto.GetMonto(), pagoDto.getTuristaId(), pagoDto.getGuiaId());
	}
}
