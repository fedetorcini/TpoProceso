package GUI.Pantallas;

import GUI.JGradientButton;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.UsuarioPackage.Turista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends Pantalla {

    private static int classId = -1;

    private ArrayList<JComponent> components;
    private JGradientButton botonPerfil;
    private JGradientButton botonViajes;
    private JGradientButton botonPagos;
    private JGradientButton botonReviews;
    private JGradientButton botonGuias;

    public MainMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        // Boton Perfil
        botonPerfil = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
        botonPerfil.setBounds( (WINDOW_WIDTH / 2) - 450, (WINDOW_HEIGHT / 2) - 400, 150, 50);
        botonPerfil.setText("Perfil");
        botonPerfil.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonPerfil);

        botonPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                botonViajes.setForeground(Color.DARK_GRAY.darker());
                botonPagos.setForeground(Color.DARK_GRAY.darker());
                botonReviews.setForeground(Color.DARK_GRAY.darker());
                botonGuias.setForeground(Color.DARK_GRAY.darker());
                botonPerfil.setForeground(mainBackgroundColor.brighter());

                TuristaDTO turista = UsuarioController.GetLoggedTurista();

                Perfil perfil = (Perfil) Perfil.GetInstance();
                perfil.SetUsuario(turista);
                perfil.Show();
            }
        });

        // Boton Viajes
        botonViajes = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
        botonViajes.setBounds( (WINDOW_WIDTH / 2) - 300, (WINDOW_HEIGHT / 2) - 400, 150, 50);
        botonViajes.setText("Viajes");
        botonViajes.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonViajes);

        // Boton Pagos
        botonPagos = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
        botonPagos.setBounds( (WINDOW_WIDTH / 2) - 150, (WINDOW_HEIGHT / 2) - 400, 150, 50);
        botonPagos.setText("Pagos");
        botonPagos.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonPagos);

        // Boton Reviews
        botonReviews = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
        botonReviews.setBounds( (WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 400, 150, 50);
        botonReviews.setText("Reviews");
        botonReviews.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonReviews);

        // Boton Guias
        botonGuias = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
        botonGuias.setBounds( (WINDOW_WIDTH / 2) + 150, (WINDOW_HEIGHT / 2) - 400, 150, 50);
        botonGuias.setText("Guias");
        botonGuias.setFont(new Font("Serif", Font.BOLD, 15));
        container.add(botonGuias);

        // Add components
        components = new ArrayList<JComponent>();
        components.add(botonPerfil);
        components.add(botonViajes);
        components.add(botonPagos);
        components.add(botonReviews);
        components.add(botonGuias);
    }
    @Override
    public void Show() {
        for (JComponent component : components)
        {
            component.show();
        }
    }
    @Override
    public void Hide() {
        for (JComponent component : components)
        {
            component.hide();
        }
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }
}
