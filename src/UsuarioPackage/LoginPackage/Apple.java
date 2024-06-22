package src.UsuarioPackage.LoginPackage;

public class Apple implements IMedioLogin{

	@Override
	public boolean RegistrarUsuario(String mail, String contraseña) {
		System.out.println("No es posible conectarse con los servidores de Apple, intente otro metodo");
		return false;
	}

	@Override
	public boolean Login(String mail, String contraseña) {
		System.out.println("No es posible conectarse con los servidores de Apple, intente otro metodo");
		return false;
	}

}
