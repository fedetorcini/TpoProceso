package GUI;

import GUI.Pantallas.*;

import GUI.Pantallas.Login.LoginGuia;
import GUI.Pantallas.Login.LoginTurista;
import GUI.Pantallas.Login.RegistroGuia;
import GUI.Pantallas.Login.RegistroTurista;
import GUI.Pantallas.Menus.GuiaMenus.*;
import GUI.Pantallas.Menus.TuristaMenus.*;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private Container container;

	private int WINDOW_HEIGHT = 800;
	private int WINDOW_WIDTH = 900;

	private long deltaTime = 33;
	private Color mainColor = Color.GREEN.darker();
	private Color secondary = Color.YELLOW.brighter();
	private Color mainBackgroundColor = Color.LIGHT_GRAY;

	public Principal(){
		this.setTitle("Hotel? TRIVAGO");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.configurar();
		this.setVisible(true); // This should be executed after configurar()
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void configurar() {
		initializeContainer();


		Pantalla main                      = new Main(mainColor, secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);

		Pantalla seleccionarRol            = new SeleccionarRol(main, mainColor, secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);

		Pantalla loginTurista              = new LoginTurista(seleccionarRol, mainColor, secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		loginTurista.Hide();

		Pantalla loginGuia                 = new LoginGuia(seleccionarRol, mainColor, secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		loginGuia.Hide();

		Pantalla registroTurista           = new RegistroTurista(loginTurista, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		registroTurista.Hide();

		Pantalla registroGuia              = new RegistroGuia(loginGuia, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		registroGuia.Hide();

		Pantalla mainMenu                  = new MainMenu(loginTurista, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		mainMenu.Hide();

		Pantalla perfilMenu                = new PerfilMenu(mainMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);

		perfilMenu.Hide();

		Pantalla viajesMenu                = new  ViajesMenu(mainMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		viajesMenu.Hide();

		Pantalla nuevoViajeMenu            = new NuevoViajeMenu(viajesMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		nuevoViajeMenu.Hide();

		Pantalla listaGuias				   = new GuiasMenu(mainMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		listaGuias.Hide();

		Pantalla reseñasMenu			   = new ReseñasMenu(mainMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		reseñasMenu.Hide();

		Pantalla pagos				   		= new PagosMenu(mainMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		pagos.Hide();

		Pantalla mainMenuGuia 			   = new MainMenuGuia(loginGuia, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		mainMenuGuia.Hide();

		PerfilGuiaMenu perfilGuiaMenu      = new PerfilGuiaMenu(mainMenuGuia, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		perfilGuiaMenu.Hide();

		ViajesGuiaMenu viajesGuiaMenu      = new ViajesGuiaMenu(mainMenuGuia, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		viajesGuiaMenu.Hide();

		ReseñasGuiaMenu reseñasGuiaMenu      = new ReseñasGuiaMenu(mainMenuGuia, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		reseñasGuiaMenu.Hide();
	}

	private void initializeContainer() {
		container = this.getContentPane();
		container.setLayout(null);
		container.setBackground(mainBackgroundColor);
	}
}
