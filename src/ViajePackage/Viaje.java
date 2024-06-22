package src.ViajePackage;

import java.util.HashMap;

import src.Reseña;
import src.ReservaPackage.Reserva;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;

public class Viaje {

private static HashMap<Integer, Viaje> viajes = new HashMap<Integer, Viaje>();
private static int IDs = 0;
private int id;
private Reserva reserva;
private Guia guia;
private Turista turista;
private double costoTotal;
private double penalidad;
private IEstadoViaje estadoViaje;
private Reseña reseña;

private Reserva GetReserva() {
	return reserva;
}

private void SetReserva(Reserva reserva) {
	this.reserva = reserva;
}

private Guia GetGuia() {
	return guia;
}

private void SetGuia(Guia guia) {
	this.guia = guia;
}

private Turista GetTurista() {
	return turista;
}

private void SetTurista(Turista turista) {
	this.turista = turista;
}

private double GetCostoTotal() {
	return costoTotal;
}

private void SetCostoTotal(double costoTotal) {
	this.costoTotal = costoTotal;
}

private double GetPenalidad() {
	return penalidad;
}

private void SetPenalidad(double penalidad) {
	this.penalidad = penalidad;
}

private IEstadoViaje GetEstadoViaje() {
	return estadoViaje;
}

private void SetEstadoViaje(IEstadoViaje estadoViaje) {
	this.estadoViaje = estadoViaje;
}

private int GetId() {
	return id;
}

private void SetId(int id) {
	this.id = id;
}

public void ResgistrarReserva(Reserva reserva)
{}

public double CalcularPenalidad()
{
	return penalidad;
}

public void CambiarEstado(IEstadoViaje estado)
{}

public void RegistrarReseña(String mensaje)
{
	reseña = Reseña.RegistrarReseña(mensaje, turista, guia, 5);
}

public void SeleccionarGuia(Guia nuevoGuia) {
	guia = nuevoGuia;
}

public static Viaje CrearViaje(Turista turista) {
	Viaje viaje = new Viaje();
	viaje.SetTurista(turista);
	viaje.SetId(IDs);
	IDs++;
	
	viajes.put(viaje.GetId(), viaje);
	
	System.out.println("Viaje creado con exito");
	return viaje;
}

public void Reservar() {
	if (guia != null)
	{
		System.out.println("Viaje reservado con exito.");
		CambiarEstado(new Reservado());		
	}
	else {
		System.out.println("Viaje no puede ser reservado sin guia.");
	}
}

public void Pagar() {
	estadoViaje.Confirmar(this);
}



}
