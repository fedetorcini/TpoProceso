package GUI.Pantallas;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class LoginTurista extends Pantalla {

    private static int classId = -1;
    private Pantalla yo = this;
    private JGradientButton botonLogin;
    private JGradientButton botonRegistrar;
    private FedeJTextField mailTexto;
    private FedeJTextField contraseñaTexto;

    public LoginTurista(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

        // Boton Registrar
        botonRegistrar = new JGradientButton(mainColor, secondary);
        botonRegistrar.setBounds( (WINDOW_WIDTH / 2) - 130, (WINDOW_HEIGHT / 2) + 50, 125, 50);
        botonRegistrar.setText("Registrar");
        botonRegistrar.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonRegistrar);

        // Boton Login
        botonLogin = new JGradientButton(mainColor, secondary);
        botonLogin.setBounds( (WINDOW_WIDTH / 2) - 5, (WINDOW_HEIGHT / 2) + 50, 125, 50);
        botonLogin.setText("Login");
        botonLogin.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonLogin);

        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String email = mailTexto.getText();
                    String contraseña = contraseñaTexto.getText();
                    UsuarioController temp = new UsuarioController();
                    TuristaDTO turista = temp.LoginTurista(email, contraseña);

                    if (turista != null)
                    {
                        JOptionPane.showMessageDialog(null, "<html><h3><center> " + turista +"  <h3>", "Tragamonedas Factory", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "<html><h3><center>A OCURRIDO UN ERROR AL CREAR LA MAQUINA <h3>", "Tragamonedas Factory", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "<html><h3><center>Ingrese unicamente numeros <h3>", "Tragamonedas Factory", JOptionPane.WARNING_MESSAGE);
                }
                mailTexto.reset();
                contraseñaTexto.reset();
            }
        });

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hide();
                RegistroUsuario.GetInstance().Show();
            }
        });

        // Create Form
        mailTexto = new FedeJTextField( (WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2) - 50, 200, 40, "Ingresar Mail");
        container.add(mailTexto);
        contraseñaTexto = new FedeJTextField( (WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2), 200, 40, "Ingreasar Contraseña");
        container.add(contraseñaTexto);
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    @Override
    public void Show() {
        botonLogin.show();
        botonRegistrar.show();
        mailTexto.show();
        contraseñaTexto.show();
    }

    @Override
    public void Hide() {
        botonLogin.hide();
        botonRegistrar.hide();
        mailTexto.hide();
        contraseñaTexto.hide();
    }
}
