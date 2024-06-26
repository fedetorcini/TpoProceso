package GUI;

import GUI.Pantallas.*;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JGradientButton cajaButton;
	private FedeJTextField cajaTextField;

	private JGradientButton botonLogin;
	private JGradientButton botonRegistrar;
	private FedeJTextField mailTexto;
	private FedeJTextField contraseñaTexto;

	private JGradientButton crearMaquinaButton;
	private FedeJTextField precioJugadaTextField;
	private FedeJTextField recaudacionIncialTextField;
	private FedeJTextField recaudacionMinimaTextField;
	private FedeJTextField catidadCasillasTextField;

	private JGradientButton crearPremioButton;
	private FedeJTextField valorPremioTextField;
	private JComboBox<String> frutasDisponibles;
	private JLabel frutasElegidas;

	private CircleButton jugarButton;
	private CircleButton retirarButton;
	private JLabel creditGUI;
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

		Pantalla main = new Main(mainColor, secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		Pantalla seleccionarRol = new SeleccionarRol(main, mainColor, secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);

		Pantalla loginTurista = new LoginTurista(seleccionarRol, mainColor, secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		loginTurista.Hide();
		Pantalla registroUsuario =  new RegistroUsuario(loginTurista, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		registroUsuario.Hide();
		Pantalla mainMenu = new MainMenu(loginTurista, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		mainMenu.Hide();
		Pantalla perfilMenu = new PerfilMenu(mainMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		perfilMenu.Hide();
		Pantalla viajesMenu = new ViajesMenu(mainMenu, mainColor,secondary, mainBackgroundColor, deltaTime, WINDOW_WIDTH, WINDOW_HEIGHT, container);
		viajesMenu.Hide();


		/*setComprarTicketForm();
		setCargarTicketForm();
		setMachineList();
		setTragamonedasDisplay();
		setCreditBanner();
		setCreateMachineForm();
		setCrearPremioForm();
		setJugarButton();
		setRetirarButton();*/
	}

	private void initializeContainer() {
		container = this.getContentPane();
		container.setLayout(null);
		container.setBackground(mainBackgroundColor);
	}

	/*private void setCreditBanner()
	{
		creditGUI = new JLabel("temp name", SwingConstants.CENTER);
		creditGUI.setBounds( WINDOW_WIDTH - 250, WINDOW_HEIGHT - 100, 200, 50);
		creditGUI.setOpaque(true);
		creditGUI.setBackground(mainColor);
		creditGUI.setText("Credito: $ " +  controlador.getCredito());
		creditGUI.setFont(new Font("Serif", Font.BOLD, 24));
		container.add(creditGUI);

		Thread t1 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	while (true)
		    	{
		    		creditGUI.setText("Credito: $ " +  controlador.getCredito());
					try {
						Thread.sleep(deltaTime);
					} catch (InterruptedException e) {
					}
		    	}
		    }
		});
		t1.start();

	}

	private void setMachineList()
	{
		machineList = new JComboBox<TragamonedasView>();
		machineList.setBounds( 10, 210, 400, 30);
		machineList.setOpaque(true);
		machineList.setBackground(mainColor);
		machineList.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	int idMaquina = ((TragamonedasView) machineList.getSelectedItem()).getId();
		    	controlador.seleccionarMaquinaActiva(idMaquina);
		    }
		});
		container.add(machineList);
	}

	private void setTragamonedasDisplay()
	{
		JLabel label = new JLabel();
		label.setBounds( 10, 250, 200, 350);
		label.setOpaque(true);
		label.setBackground(mainColor);
		container.add(label);

		Thread t2 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	while (true)
		    	{
		    		int contador = 0;
		    		String result = "<html><h2>PREMIOS";
		    		for (PremioView premio : controlador.getPremios()) {
		    			contador ++;
		    			result += "<h3>Premio Nº: " + contador + "<p>";
		    			result += "Recompensa :" + premio.getGanancia() + "<p>";
		    			for (Integer fruta : premio.getCombinacion())
		    			{
		    				result += EnteroAFruta(fruta) + "<p>";
		    			}
		    			result += "-----------<p>";
		    		}
		    		label.setText(result);
					try {
						Thread.sleep(deltaTime * 30);
					} catch (InterruptedException e) {}
		    	}
		    }
		});
		t2.start();


		JLabel ultimaCombinacionDisplay = new JLabel();
		ultimaCombinacionDisplay.setBounds( 220, 250, 200, 350);
		ultimaCombinacionDisplay.setOpaque(true);
		ultimaCombinacionDisplay.setBackground(mainColor);
		container.add(ultimaCombinacionDisplay);

		Thread t3 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	while (true)
		    	{
		    		String text = "<html><h2>ULTIMA COMBINACION <p>";
	    			for (int fruta : controlador.getUltimaCombinacion())
	    			{
	    				text += EnteroAFruta(fruta) + "<p>";
	    			}
		    		ultimaCombinacionDisplay.setText(text);
		    	}
		    }
		});
		t3.start();
	}
	private void setCreateMachineForm()
	{
		crearMaquinaButton = new JGradientButton(mainColor, secondary);
		crearMaquinaButton.setBounds( 10, 10, 200, 50);
		crearMaquinaButton.setText("Crear Maquina");
		crearMaquinaButton.setFont(new Font("Serif", Font.BOLD, 20));
		container.add(crearMaquinaButton);

		crearMaquinaButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		int precioJugada = Integer.parseInt(precioJugadaTextField.getText());
		    		int recaudacionIncial = Integer.parseInt(recaudacionIncialTextField.getText());
		    		int recaudacionMinima = Integer.parseInt(recaudacionMinimaTextField.getText());
		    		int catidadCasillas = Integer.parseInt(catidadCasillasTextField.getText());
		    		TragamonedasView temp = controlador.getMaquinaConId(controlador.crearMaquina(precioJugada, recaudacionIncial, recaudacionMinima, catidadCasillas));
		    		if ( temp != null )
		    		{
		    			machineList.addItem(temp);
		    		}
		    		else
		    		{
			    		JOptionPane.showMessageDialog(null, "<h3><center>A OCURRIDO UN ERROR AL CREAR LA MAQUINA <h3>", "Tragamonedas Factory", JOptionPane.ERROR_MESSAGE);
		    		}

		    	} catch (NumberFormatException error){
		    		JOptionPane.showMessageDialog(null, "<html><h3><center>Ingrese unicamente numeros <h3>", "Tragamonedas Factory", JOptionPane.WARNING_MESSAGE);
		    	}
		    	precioJugadaTextField.reset();
		    	recaudacionIncialTextField.reset();
		    	recaudacionMinimaTextField.reset();
		    	catidadCasillasTextField.reset();
		    }
		});

		precioJugadaTextField = new FedeJTextField( 10, 60, 100, 50, "Precio Jugada");
		container.add(precioJugadaTextField);
		recaudacionIncialTextField = new FedeJTextField( 110, 60, 100, 50, "Rec. Inicial");
		container.add(recaudacionIncialTextField);
		recaudacionMinimaTextField = new FedeJTextField( 10, 110, 100, 50, "Rec. Minima");
		container.add(recaudacionMinimaTextField);
		catidadCasillasTextField = new FedeJTextField( 110, 110, 100, 50, "# Casillas");
		container.add(catidadCasillasTextField);

	}

	private static int frutaAEntero(String fruta)
	{
		switch (fruta)
		{
		case "Banana":
			return 0;
		case "Frutilla":
			return 1;
		case "Guinda":
			return 2;
		case "Manzana":
			return 3;
		case "Sandia":
			return 4;
		case "Uva":
			return 5;
		default:
			return -1;
		}
	}

	private static String EnteroAFruta(int entero)
	{
		switch (entero)
		{
		case 0:
			return "Banana";
		case 1:
			return "Frutilla";
		case 2:
			return "Guinda";
		case 3:
			return "Manzana";
		case 4:
			return "Sandia";
		case 5:
			return "Uva";
		default:
			return "NONE";
		}
	}
	private void setCrearPremioForm()
	{
		crearPremioButton = new JGradientButton(mainColor, secondary);
		crearPremioButton.setBounds( 220, 10, 100, 50);
		crearPremioButton.setText("<html><center>Crear<p>Premio</html>");
		crearPremioButton.setFont(new Font("Serif", Font.BOLD, 15));
		container.add(crearPremioButton);

		valorPremioTextField = new FedeJTextField(321, 10, 100, 50, "Valor");
		container.add(valorPremioTextField);

		frutasElegidas = new JLabel("", SwingConstants.CENTER);
		frutasElegidas.setOpaque(true);
		frutasElegidas.setBounds( 321, 60, 100, 120);
		frutasElegidas.setBackground(mainColor);
		frutasElegidas.setFont(new Font("Times", Font.PLAIN, 15));
		container.add(frutasElegidas);

		frutasDisponibles = new JComboBox<String>();
		frutasDisponibles.setBounds( 220, 60, 100, 30);
		frutasDisponibles.setBackground(mainColor);
		frutasDisponibles.addItem("Banana");
		frutasDisponibles.addItem("Frutilla");
		frutasDisponibles.addItem("Guinda");
		frutasDisponibles.addItem("Manzana");
		frutasDisponibles.addItem("Sandia");
		frutasDisponibles.addItem("Uva");
		frutasDisponibles.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	String fruta = frutasDisponibles.getSelectedItem().toString();
		    	frutasList.add(frutaAEntero(fruta));
		    	frutasElegidas.setText("<html><center>" + frutasElegidas.getText() + "<p>" + fruta);
		    }
		});
		container.add(frutasDisponibles);

		crearPremioButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
		    		int[] frutasArr = new int[frutasList.size()];
		    		for (int  i = 0; i < frutasList.size(); i ++)
		    		{
		    			frutasArr[i] = frutasList.get(i);
		    		}
		    		controlador.agregarPremio(Integer.parseInt(valorPremioTextField.getText()),frutasArr);
		    	} catch (NumberFormatException ex1){
		    		JOptionPane.showMessageDialog(null, "<html><h3><center>Solo se aceptan valores numericos<h3>", "Tragamonedas", JOptionPane.ERROR_MESSAGE);
		    	} catch (YaExistePremioConEsaCombinacionException ex2){
		    		JOptionPane.showMessageDialog(null, "<html><h3><center>No puede ingresar premios con combinacion repetida<h3>", "Tragamonedas", JOptionPane.ERROR_MESSAGE);
		    	} catch (CantidadDeFrutasInvalidaException ex3){
		    		JOptionPane.showMessageDialog(null, "<html><h3><center>Verifique la cantidad de frutas<h3>", "Tragamonedas", JOptionPane.ERROR_MESSAGE);
		    	}

		    	frutasList = new ArrayList<Integer>();
		    	valorPremioTextField.reset();
		    	frutasElegidas.setText("");
		    }
		});
	}

	private void setComprarTicketForm()
	{

		cajaButton = new JGradientButton(mainColor, secondary);
		cajaButton.setBounds( WINDOW_WIDTH - 250, 10, 200, 50);
		cajaButton.setText("Comprar Credito ");
		cajaButton.setFont(new Font("Serif", Font.BOLD, 20));
		container.add(cajaButton);

		cajaButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		int value = Integer.parseInt(cajaTextField.getText());
		    		int idTicket = controlador.comprarTicket(value);
		    		JOptionPane.showMessageDialog(null,
		    						"<html><h1><center>Id Ticket: "
		    						+ idTicket +
		    						"<h3><center>Recuerda Anotar el Id del Ticket."
		    						+ "<h3<center>NO Hay reembolzo en caso de perdida.",
		    						"Venta de ticket",
		    						JOptionPane.WARNING_MESSAGE
		    				);
		    	} catch (NumberFormatException error){
		    		JOptionPane.showMessageDialog(null, "Ingresar un numero valido");
		    	}
		    	cajaTextField.setText("Ingresar valor");
		    }
		});

		cajaTextField = new FedeJTextField(WINDOW_WIDTH - 200, 60, 100, 50, "Ingresar Valor");
		container.add(cajaTextField);
	}

	private void setCargarTicketForm()
	{
		cargarMaquinaButton = new JGradientButton(mainColor, secondary);
		cargarMaquinaButton.setBounds( WINDOW_WIDTH - 250, 160, 200, 50);
		cargarMaquinaButton.setText("Cargar Maquina");
		cargarMaquinaButton.setFont(new Font("Serif", Font.BOLD, 20));
		container.add(cargarMaquinaButton);

		cargarMaquinaButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
		    		int value = Integer.parseInt(cargarMaquinaTextField.getText());
		    		if (controlador.cargarCredito(value))
		    		{
		    			JOptionPane.showMessageDialog(null,
		    					"<html><h2><center>Id Ticket: "
		    							+ value +
		    							"<h3><center> Carga realizada correcatmente.",
		    							"Carga de Maquina",
		    							JOptionPane.INFORMATION_MESSAGE
		    					);
		    		}
		    		else
		    		{
		    			JOptionPane.showMessageDialog(null,
		    					"<html><h2><center>Id Ticket: "
		    							+ value +
		    							"<h3><center> Id invalido o ticket ya utilizado.",
		    							"Carga de Maquina",
		    							JOptionPane.WARNING_MESSAGE
		    					);
		    		}

		    	} catch (NumberFormatException error){
		    		JOptionPane.showMessageDialog(null, "Ingresar un numero valido");
		    	}
		    	cargarMaquinaTextField.setText("Ticket ID");
		    }
		});

		cargarMaquinaTextField = new FedeJTextField(WINDOW_WIDTH - 200, 210, 100, 50, "Ticket ID");
		container.add(cargarMaquinaTextField);
	}

	private void setJugarButton()
	{
		jugarButton = new CircleButton("Jugar", mainColor, secondary, Color.RED);
		jugarButton.setBounds( 60, WINDOW_HEIGHT - 170, 100, 100);
		jugarButton.setFont(new Font("Arial", Font.BOLD, 30));
		container.add(jugarButton);

		jugarButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	try {
					int result = controlador.jugarConMaquina();
					if (result == TragamonedasView.VICTORY)
					{
						JOptionPane.showMessageDialog(null,
								"<html><center> HAS GANADO!",
								"Staff",
								JOptionPane.INFORMATION_MESSAGE
						);
					}
				} catch (NoHaySaldoSuficienteException ex2) {
					JOptionPane.showMessageDialog(null,
							"<html><center> La maquina que desea utilizar no tiene suficiente credito cargado",
							"Staff",
							JOptionPane.INFORMATION_MESSAGE
					);
				} catch (NoSePuedePagarPremioException ex1) {
					int response = JOptionPane.showConfirmDialog(null, "<html><center>No hay saldo para pagar los premios.<p> Desea continuar?", "Tragamonedas",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.YES_OPTION)
				    {
				    	controlador.jugarSinBeneficios();
				    }
				}
		    }
		});
	}
	void setRetirarButton ()
	{
		retirarButton = new CircleButton("Retirar", mainColor, secondary, Color.CYAN);
		retirarButton.setBounds( 200, WINDOW_HEIGHT - 150, 75, 75);
		retirarButton.setFont(new Font("Arial", Font.BOLD, 20));
		container.add(retirarButton);

		retirarButton.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				if (controlador.getCredito() > 0) {
		    		TicketView ticket = controlador.retirarCreditoDeMaquina();
		    		if (ticket != null)
		    		{
	    				JOptionPane.showMessageDialog(null,
	    						"<html><h1><cfenter>Id Ticket: "
	    						+ ticket.getId() + "<p>valor : " + ticket.getValor() +
	    						"<h3><center>Recuerda Anotar el Id del Ticket."
	    						+ "<h3<center>NO Hay reembolzo en caso de perdida.",
	    						"Venta de ticket",
	    						JOptionPane.INFORMATION_MESSAGE
	    				);
		    		}
				}

		    }
		});
	}*/
}
