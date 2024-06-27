package src.ViajePackage.Controller;

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
	}

	public void AgregarReseña(ReseñaDTO reseñaDto) {

		Reseña reseña = new Reseña();
		reseña.RegistrarReseña(reseñaDto);

		Viaje viaje = new Viaje();
		viaje.GetPorDTO(reseñaDto.GetViaje());

		Turista turista = new Turista();
		turista.GetPorId(viaje.GetTuristaId());

		Guia guia = new Guia();
		guia.GetPorId(viaje.GetGuiaId());

		turista.AgregarReseña(reseña);
		guia.AgregarReseña(reseña);
	}

	public void EnviarMensaje(ViajeDTO viajeDTO, String string) {
			Mensaje mensaje = new Mensaje(string);

			Viaje viaje = new Viaje();
			viaje.GetPorDTO(viajeDTO);

			viaje.PublicarAlChatDeViaje(mensaje);
		}

	public ArrayList<ViajeDTO> GetViajesDe(TuristaDTO filter) {
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

}
