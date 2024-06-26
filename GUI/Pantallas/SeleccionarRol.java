package GUI.Pantallas;

import GUI.JGradientButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarRol extends Pantalla{
    private static int classId = -1;

    private JGradientButton botonGuia;
    private JGradientButton botonTurista;
    public SeleccionarRol(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        botonGuia = new JGradientButton(mainColor, secondary);
        botonGuia.setBounds( (WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2) + 200, 100, 50);
        botonGuia.setText("Guía");
        botonGuia.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonGuia);

        botonGuia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Hide();
                    LoginGuia.GetInstance().Show();
                } catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "<html><h3><center>Ingrese unicamente numeros <h3>", "Tragamonedas Factory", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
            botonTurista = new JGradientButton(mainColor, secondary);
            botonTurista.setBounds( (WINDOW_WIDTH / 2) +100, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            botonTurista.setText("Turista");
            botonTurista.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonTurista);
        botonTurista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Hide();
                    LoginTurista.GetInstance().Show();
                } catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "<html><h3><center>Ingrese unicamente numeros <h3>", "Tragamonedas Factory", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    @Override
    public void Show() {
        botonGuia.show();
        botonTurista.show();
    }

    @Override
    public void Hide() {
        botonGuia.hide();
        botonTurista.hide();
    }
}
