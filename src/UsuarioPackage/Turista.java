package src.UsuarioPackage;

import java.util.HashMap;

import src.NotificadorPackage.Notificador;
import src.UsuarioPackage.TrofeoPackage.TrofeoReseña;
import src.ViajePackage.Reseña;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.LoginPackage.IMedioLogin;
import src.ViajePackage.Viaje;

public class Turista extends Usuario<Turista>{

private static HashMap<Integer, Turista> turistas = new HashMap<Integer, Turista>();

private void Initialize(Turista turista) {
	Initialize(turista.medioLogin, turista.nombre, turista.apellido, turista.mail, "", turista.sexo, turista.dni, turista.telefono);
	this.id = turista.id;
	this.notificador = turista.notificador;
	this.viajes = turista.viajes;
	this.observadores = turista.observadores;
}

public void Initialize(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
	InitializeUsuario(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono);
}

public void RegistrarTurista(IMedioLogin medioLogin, String nombre, String apellido, String mail, String contraseña, String sexo, int dni, int telefono) {
	if (medioLogin.RegistrarUsuario(mail, contraseña))
	{
		this.notificador = new Notificador();
		TrofeoReseña.GetInstancia().Suscribir(this.notificador);
		this.Suscribir(TrofeoReseña.GetInstancia());

		this.Initialize(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono);
		this.id = IDs;
		IDs++;
		turistas.put(id, this);
		System.out.println("Turista " + nombre + " " + apellido + " registrado exitosamente.");
	}
	else
	{
		System.out.println("Turista " + nombre + " " + apellido + " no a podido ser registrado.");
	}	
}

public boolean Login(String email, String contraseña) {
	return medioLogin.Login(email, contraseña);
}
@Override
public void ActualizarPerfil(String nombre, String apellido, String sexo, int telefono, int dni) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.sexo = sexo;
	this.telefono = telefono;
	this.dni = dni;

	turistas.put(id, this);
}

public TuristaDTO ToDTO() {
	return new TuristaDTO(this);
}

public boolean GetPorId(int id) {

	boolean success = false;

	for(Turista turista : turistas.values()) {
		if (turista.id == id) {
			Initialize(turista);
			success = true;
		}
	}
	return success;
}

public boolean GetPorMail(String email) {

	boolean success = false;

	for(Turista turista : turistas.values()) {
		if (turista.mail.equals(email)) {
			Initialize(turista);
			success = true;
			break;
		}
	}
	return success;
}

public boolean GetPorDTO(TuristaDTO turistaDTO) {
	return GetPorMail(turistaDTO.GetMail());
}

public void AgregarViaje(Viaje viaje) {
	viajes.put(viaje.GetId(), viaje);
	turistas.put(id, this);
}

public void AgregarReseña(Reseña reseña) {
	if (viajes.containsKey(reseña.GetViajeId())){
		Publicar(this);
	}
}
@Override
public String toString() {
		return nombre + " " + apellido;
}
}
