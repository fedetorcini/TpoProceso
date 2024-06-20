package src.Usuario;

public class Usuario {

private static int IDs = 0;
private int myId;
private String nombre;
private String apellido;
private String mail;

private int GetMyId() {
	return myId;
}

private void SetMyId(int myId) {
	this.myId = myId;
}

private String GetApellido() {
	return apellido;
}

private void SetApellido(String apellido) {
	this.apellido = apellido;
}

private String GetNombre() {
	return nombre;
}

private void SetNombre(String nombre) {
	this.nombre = nombre;
}

private String GetMail() {
	return mail;
}

private void SetMail(String mail) {
	this.mail = mail;
}


public static Usuario RegistrarUsuario(String nombre, String apellido, String mail)
{

	Usuario myUsuario = new Usuario();
	myUsuario.SetApellido(apellido);
	myUsuario.SetNombre(nombre);
	myUsuario.SetMyId(IDs);
	myUsuario.SetMail(mail);
	IDs++;
	
	System.out.println("Usuario " + nombre + " " + apellido + " registrado exitosamente");
	return myUsuario;
}

}
