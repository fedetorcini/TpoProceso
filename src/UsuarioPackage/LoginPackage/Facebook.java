package src.UsuarioPackage.LoginPackage;

import src.UsuarioPackage.ControllerPackage.UsuarioController;

public class Facebook implements IMedioLogin{

	@Override
	public boolean RegistrarUsuario(String mail, String contraseña) {
		System.out.println("No es posible conectarse con los servidores de Facebook, intente otro metodo");
		return false;
	}

	@Override
	public boolean Login(String mail, String contraseña) {
		System.out.println("No es posible conectarse con los servidores de Facebook, intente otro metodo");
		return false;
	}
}
