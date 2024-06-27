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

public UsuarioDTO(Usuario usuario) {
		this.id = usuario.GetId();
		this.nombre = usuario.GetNombre();
		this.apellido = usuario.GetApellido();
		this.mail = usuario.GetMail();
		this.sexo = usuario.GetSexo();
		this.dni = usuario.GetDni();
		this.telefono = usuario.GetTelefono();
}

public String GetMail() {
	return mail;
}

public int GetId(){
	return id;
}

public String GetNombre() { return nombre; }

public String GetApellido() { return apellido; }

public String GetSexo() { return sexo; }

public int GetDni() {return dni; }

public int GetTelefono() { return telefono; }

public String toString(){
	return nombre + " " + apellido;
}
}
