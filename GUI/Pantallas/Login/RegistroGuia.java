package GUI.Pantallas.Login;


import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistroGuia extends Pantalla {

    private static int classId = -1;

    private JLabel titulo;

    private JComboBox<String> loginBox;
    private JComboBox<String> sexoBox;

    private JGradientButton botonConfirmar;
    private JGradientButton botonAtras;

    private FedeJTextField  mailTexto;
    private FedeJTextField  contraseñaTexto;
    private FedeJTextField  nombreTexto;
    private FedeJTextField  apellidoTexto;
    private FedeJTextField  telefonoTexto;
    private FedeJTextField  dniTexto;
    private FedeJTextField paisTexto;
    private FedeJTextField ciudadTexto;

    public RegistroGuia(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

        // Pantalla Banner
        {
            titulo = new JLabel("temp name", SwingConstants.CENTER);
            titulo.setBounds((WINDOW_WIDTH/2) - 100, 200, 200, 50);
            titulo.setOpaque(true);
            titulo.setBackground(mainBackgroundColor.darker());
            titulo.setText(" Registro Guia ");
            titulo.setFont(new Font("Serif", Font.BOLD, 24));
            container.add(titulo);
        }

        // Boton Confirmar
        {
            botonConfirmar = new JGradientButton(mainColor, secondary);
            botonConfirmar.setBounds((WINDOW_WIDTH / 2) - 150, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            botonConfirmar.setText("Enviar");
            botonConfirmar.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonConfirmar);

            botonConfirmar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UsuarioController UC = new UsuarioController();

                    String nombre = nombreTexto.getText();
                    String apellido = apellidoTexto.getText();
                    String contraseña = contraseñaTexto.getText();
                    String sexo = (String) sexoBox.getSelectedItem();
                    int telefono = Integer.parseInt(telefonoTexto.getText());
                    int dni = Integer.parseInt(dniTexto.getText());
                    String mail = mailTexto.getText();
                    String medioLogin = (String) loginBox.getSelectedItem();
                    String pais = paisTexto.getText();
                    String ciudad = ciudadTexto.getText();
                    UC.RegistrarGuia(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono, pais, ciudad);

                    Hide();
                    LoginTurista.GetInstance().Show();
                    ;
                }
            });
        }

        // Boton Atras
        {
            botonAtras = new JGradientButton(Color.RED.darker(), secondary);
            botonAtras.setBounds((WINDOW_WIDTH / 2) + 50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            botonAtras.setText("Atras");
            botonAtras.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonAtras);

            botonAtras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    LoginGuia.GetInstance().Show();
                }
            });
        }

        // Create Form
        {
            paisTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 200, 200, 40, "Ingresar Pais");
            container.add(paisTexto);
            ciudadTexto = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 200, 200, 40, "Ingresar Ciudad");
            container.add(ciudadTexto);
            mailTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 100, 200, 40, "Ingresar Mail");
            container.add(mailTexto);
            contraseñaTexto = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 100, 200, 40, "Ingresar Contraseña");
            container.add(contraseñaTexto);
            nombreTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 50, 200, 40, "Ingresar Nombre");
            container.add(nombreTexto);
            apellidoTexto = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 50, 200, 40, "Ingresar Apellido");
            container.add(apellidoTexto);
            telefonoTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2), 200, 40, "Ingresar Telefono");
            container.add(telefonoTexto);
            dniTexto = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2), 200, 40, "Ingresar Dni");
            container.add(dniTexto);



            sexoBox = new JComboBox<String>();
            sexoBox.setBounds((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) + 50, 200, 40);
            sexoBox.setOpaque(false);
            sexoBox.setBackground(mainBackgroundColor);
            sexoBox.addItem("Masculino");
            sexoBox.addItem("Femenino");
            container.add(sexoBox);

            loginBox = new JComboBox<String>();
            loginBox.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) + 50, 200, 40);
            loginBox.setOpaque(false);
            loginBox.setBackground(mainBackgroundColor);
            loginBox.addItem(UsuarioController.MEDIO_LOGIN_APPLE);
            loginBox.addItem(UsuarioController.MEDIO_LOGIN_MAIL);
            loginBox.addItem(UsuarioController.MEDIO_LOGIN_GOOGLE);
            loginBox.addItem(UsuarioController.MEDIO_LOGIN_FACEBOOK);
            container.add(loginBox);
        }

        // Add components
        {
            components = new ArrayList<JComponent>();
            components.add(titulo);
            components.add(botonConfirmar);
            components.add(botonAtras);
            components.add(mailTexto);
            components.add(contraseñaTexto);
            components.add(nombreTexto);
            components.add(apellidoTexto);
            components.add(telefonoTexto);
            components.add(dniTexto);
            components.add(sexoBox);
            components.add(loginBox);
            components.add(paisTexto);
            components.add(ciudadTexto);
        }

    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

}
