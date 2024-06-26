package src.UsuarioPackage.ControllerPackage;

import java.util.HashMap;

import src.UsuarioPackage.Usuario;
import src.ViajePackage.Controller.ViajeDTO;

public class UsuarioDTO {

private int id;
private String nombre;
private String apellido;
private String mail;
private String sexo;
private int dni;
private int telefono;
private HashMap<Integer, ViajeDTO> viajes;

public UsuarioDTO(Usuario turista) {
		super();
		this.id = turista.GetId();
		this.nombre = turista.GetNombre();
		this.apellido = turista.GetApellido();
		this.mail = turista.GetMail();
		this.sexo = turista.GetSexo();
		this.dni = turista.GetDni();
		this.telefono = turista.GetTelefono();
		// ? this.viajes = turista.GetViajes();
}

public String GetMail() {
	return mail;
}

public int GetId(){
	return id;
}

public String toString(){
	return nombre + " " + apellido;
}

}
