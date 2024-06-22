package src.UsuarioPackage.LoginPackage;

public class Google implements IMedioLogin{

	@Override
	public boolean RegistrarUsuario(String mail, String contraseña) {
		System.out.println("No es posible conectarse con los servidores de Google, intente otro metodo");
		return false;
	}

	@Override
	public boolean Login(String mail, String contraseña) {
		System.out.println("No es posible conectarse con los servidores de Google, intente otro metodo");
		return false;
	}

}
