package src.UsuarioPackage;

public class Usuario {

protected static int IDs = 0;
private int id;
private String nombre;
private String apellido;
private String mail;
private String sexo;
private int dni;
private int telefono;

protected int GetId() {
	return id;
}

protected void SetId(int myId) {
	this.id = myId;
}

protected String GetApellido() {
	return apellido;
}

protected void SetApellido(String apellido) {
	this.apellido = apellido;
}

protected String GetNombre() {
	return nombre;
}

protected void SetNombre(String nombre) {
	this.nombre = nombre;
}

protected String GetMail() {
	return mail;
}

protected void SetMail(String mail) {
	this.mail = mail;
}

}
