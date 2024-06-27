package GUI.Pantallas;

import GUI.JGradientButton;
import GUI.Pantallas.Login.LoginGuia;
import GUI.Pantallas.Login.LoginTurista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeleccionarRol extends Pantalla{
    private static int classId = -1;

    private JLabel titulo;

    private JGradientButton botonGuia;
    private JGradientButton botonTurista;

    public SeleccionarRol(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        // Pantalla Banner
        {
            titulo = new JLabel("temp name", SwingConstants.CENTER);
            titulo.setBounds((WINDOW_WIDTH/2) - 200, 100, 400, 50);
            titulo.setOpaque(true);
            titulo.setBackground(mainBackgroundColor);
            titulo.setText(" Seleccionar Rol ");
            titulo.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(titulo);
        }

        // Boton Guia
        {
            botonGuia = new JGradientButton(mainBackgroundColor, mainBackgroundColor);
            botonGuia.setBounds((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 200, 250, 100);
            botonGuia.setText("Guía");
            botonGuia.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonGuia);

            botonGuia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    LoginGuia.GetInstance().Show();
                }
            });
        }

        // Boton Turista
        {
            botonTurista = new JGradientButton(mainBackgroundColor, mainBackgroundColor);
            botonTurista.setBounds((WINDOW_WIDTH / 2) - 250, (WINDOW_HEIGHT / 2) - 200, 250, 100);
            botonTurista.setText("Turista");
            botonTurista.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonTurista);

            botonTurista.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    LoginTurista.GetInstance().Show();
                }
            });
        }

        // Componentes
        {
            components = new ArrayList<>();
            components.add(titulo);
            components.add(botonGuia);
            components.add(botonTurista);
        }
    }

    public static Pantalla GetInstance() { return Pantalla.GetById(classId); }

}
