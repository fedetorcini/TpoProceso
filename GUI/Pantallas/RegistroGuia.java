package GUI.Pantallas;


import GUI.FedeJTextField;
import GUI.JGradientButton;
import src.UsuarioPackage.ControllerPackage.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroGuia extends Pantalla{

    private static int classId = -1;
    private JComboBox<String> loginBox;
    private JComboBox<String> sexoBox;
    private JGradientButton botonConfirmar;
    private FedeJTextField  mailTexto;
    private FedeJTextField  contraseñaTexto;
    private FedeJTextField  nombreTexto;
    private FedeJTextField  apellidoTexto;
    private FedeJTextField  telefonoTexto;
    private FedeJTextField  dniTexto;

    public RegistroGuia(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

        // Boton Confirmar
        botonConfirmar = new JGradientButton(mainColor, secondary);
        botonConfirmar.setBounds( (WINDOW_WIDTH / 2) - 50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
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
                UC.RegistrarTurista(medioLogin, nombre, apellido, mail, contraseña, sexo, dni, telefono);

                Hide();
                LoginGuia.GetInstance().Show();
                ;            }
        });

        // Create Form
        mailTexto = new FedeJTextField( (WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 100, 200, 40, "Ingresar Mail");
        container.add(mailTexto);
        contraseñaTexto = new FedeJTextField( (WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 100, 200, 40, "Ingreasar Contraseña");
        container.add(contraseñaTexto);
        nombreTexto = new FedeJTextField( (WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 50, 200, 40, "Ingresar Nombre");
        container.add(nombreTexto);
        apellidoTexto = new FedeJTextField( (WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 50, 200, 40, "Ingreasar Apellido");
        container.add(apellidoTexto);
        telefonoTexto = new FedeJTextField( (WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2), 200, 40, "Ingresar Telefono");
        container.add(telefonoTexto);
        dniTexto = new FedeJTextField( (WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2), 200, 40, "Ingreasar Dni");
        container.add(dniTexto);

        sexoBox = new JComboBox<String>();
        sexoBox.setBounds( (WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) + 50, 200, 40);
        sexoBox.setOpaque(false);
        sexoBox.setBackground(mainBackgroundColor);
        sexoBox.addItem("Masculino");
        sexoBox.addItem("Femenino");
        container.add(sexoBox);

        loginBox = new JComboBox<String>();
        loginBox.setBounds( (WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) + 50, 200, 40);
        loginBox.setOpaque(false);
        loginBox.setBackground(mainBackgroundColor);
        loginBox.addItem(UsuarioController.MEDIO_LOGIN_APPLE);
        loginBox.addItem(UsuarioController.MEDIO_LOGIN_MAIL);
        loginBox.addItem(UsuarioController.MEDIO_LOGIN_GOOGLE);
        loginBox.addItem(UsuarioController.MEDIO_LOGIN_FACEBOOK);
        container.add(loginBox);
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void Show() {
        botonConfirmar.show();
        mailTexto.show();
        contraseñaTexto.show();
        nombreTexto.show();
        apellidoTexto.show();
        telefonoTexto.show();
        dniTexto.show();
        sexoBox.show();
        loginBox.show();
    }
    @Override
    public void Hide() {
        botonConfirmar.hide();
        mailTexto.hide();
        contraseñaTexto.hide();
        nombreTexto.hide();
        apellidoTexto.hide();
        telefonoTexto.hide();
        dniTexto.hide();
        sexoBox.hide();
        loginBox.hide();
    }
}
