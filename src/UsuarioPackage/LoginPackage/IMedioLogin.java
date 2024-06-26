package src.UsuarioPackage.LoginPackage;

public interface IMedioLogin {

boolean RegistrarUsuario(String mail, String contraseña);
boolean Login(String mail, String contraseña);

}
