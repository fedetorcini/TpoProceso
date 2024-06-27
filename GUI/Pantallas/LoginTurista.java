package GUI.Pantallas;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Menus.MainMenu;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginTurista extends Pantalla {

    private static int classId = -1;

    private JLabel titulo;

    private JGradientButton botonLogin;
    private JGradientButton botonRegistrar;
    private JGradientButton botonAtras;

    private FedeJTextField mailTexto;
    private FedeJTextField contraseñaTexto;

    public LoginTurista(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

        // Pantalla Banner
        {
            titulo = new JLabel("temp name", SwingConstants.CENTER);
            titulo.setBounds((WINDOW_WIDTH/2) - 100, 200, 200, 50);
            titulo.setOpaque(true);
            titulo.setBackground(mainBackgroundColor.darker());
            titulo.setText(" Login Turista ");
            titulo.setFont(new Font("Serif", Font.BOLD, 24));
            container.add(titulo);
        }

        // Boton Registrar
        {
            botonRegistrar = new JGradientButton(mainColor, secondary);
            botonRegistrar.setBounds((WINDOW_WIDTH / 2) - 130, (WINDOW_HEIGHT / 2) + 50, 125, 50);
            botonRegistrar.setText("Registrar");
            botonRegistrar.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonRegistrar);

            botonRegistrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    RegistroTurista.GetInstance().Show();
                }
            });
        }

        // Boton Login
        {
            botonLogin = new JGradientButton(mainColor, secondary);
            botonLogin.setBounds((WINDOW_WIDTH / 2) - 5, (WINDOW_HEIGHT / 2) + 50, 125, 50);
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

                        //if (turista != null)
                        {
                            //JOptionPane.showMessageDialog(null, "<html><h3><center> " + turista +"  <h3>", "Tragamonedas Factory", JOptionPane.INFORMATION_MESSAGE);
                            Hide();
                            MainMenu.GetInstance().Show();
                        }
                        //else
                        {
                            //JOptionPane.showMessageDialog(null, "<html><h3><center>A OCURRIDO UN ERROR AL CREAR LA MAQUINA <h3>", "Tragamonedas Factory", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException error) {
                        JOptionPane.showMessageDialog(null, "<html><h3><center>Ingrese unicamente numeros <h3>", "Tragamonedas Factory", JOptionPane.WARNING_MESSAGE);
                    }
                    mailTexto.reset();
                    contraseñaTexto.reset();
                }
            });
        }

        // Boton Atras
        {
            botonAtras = new JGradientButton(Color.RED.darker(), secondary);
            botonAtras.setBounds((WINDOW_WIDTH / 2) - 50, (WINDOW_HEIGHT / 2) + 100, 100, 50);
            botonAtras.setText("Atras");
            botonAtras.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonAtras);

            botonAtras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    SeleccionarRol.GetInstance().Show();
                }
            });
        }

        // Create Form
        {
            mailTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2) - 50, 200, 40, /*"Ingresar Mail"*/"mail");
            container.add(mailTexto);
            contraseñaTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2), 200, 40, /*"Ingreasar Contraseña"*/"contra");
            container.add(contraseñaTexto);
        }

        // Add components
        {
            components = new ArrayList<JComponent>();
            components.add(titulo);
            components.add(botonLogin);
            components.add(botonRegistrar);
            components.add(botonAtras);
            components.add(mailTexto);
            components.add(contraseñaTexto);
        }
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

}
