package GUI.Pantallas.Menus;

import GUI.JGradientButton;
import GUI.Pantallas.Login.LoginTurista;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.ViajeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends Pantalla {

    private static int classId = -1;

    private ArrayList<Pantalla> subpantallas;

    private JGradientButton botonPerfil;
    private JGradientButton botonViajes;
    private JGradientButton botonPagos;
    private JGradientButton botonReviews;
    private JGradientButton botonGuias;
    private JGradientButton botonAtras;

    public MainMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;
        subpantallas = new ArrayList<Pantalla>();

        // Boton Perfil
        {
            botonPerfil = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonPerfil.setBounds((WINDOW_WIDTH / 2) - 450, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonPerfil.setText("Perfil");
            botonPerfil.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonPerfil);

            botonPerfil.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();

                    botonPerfil.setForeground(mainBackgroundColor.brighter());

                    TuristaDTO turista = UsuarioController.GetLoggedTurista();

                    PerfilMenu perfil = (PerfilMenu) PerfilMenu.GetInstance();
                    subpantallas.add(perfil);
                    perfil.SetUsuario(turista);
                    perfil.Show();
                }
            });
        }

        // Boton Viajes
        {
            botonViajes = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonViajes.setBounds((WINDOW_WIDTH / 2) - 300, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonViajes.setText("Viajes");
            botonViajes.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonViajes);

            botonViajes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();

                    botonViajes.setForeground(mainBackgroundColor.brighter());

                    ViajesMenu viajesMenu = (ViajesMenu) ViajesMenu.GetInstance();
                    if (!subpantallas.contains(viajesMenu))
                        subpantallas.add(viajesMenu);
                    viajesMenu.Show();
                    ViajeController vc = new ViajeController();
                    viajesMenu.Actualizar(vc.GetViajesDe(UsuarioController.GetLoggedTurista()));
                }
            });
        }

        // Boton Pagos
        {
            botonPagos = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonPagos.setBounds((WINDOW_WIDTH / 2) - 150, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonPagos.setText("Pagos");
            botonPagos.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonPagos);
        }

        // Boton Reviews
        {
            botonReviews = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonReviews.setBounds((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonReviews.setText("Reviews");
            botonReviews.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonReviews);
        }

        // Boton Guias
        {
            botonGuias = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonGuias.setBounds((WINDOW_WIDTH / 2) + 150, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonGuias.setText("Guias");
            botonGuias.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonGuias);

            botonGuias.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();
                    botonGuias.setForeground(mainBackgroundColor.brighter());
                    GuiasMenu guiasMenu = (GuiasMenu) GuiasMenu.GetInstance();
                    subpantallas.add(guiasMenu);
                    guiasMenu.Show();
                    UsuarioController uc = new UsuarioController();
                    guiasMenu.Actualizar(UsuarioController.GetGuia(null));
                }
            });
        }

        // Boton Atras
        {
            botonAtras = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonAtras.setBounds((WINDOW_WIDTH / 2) + 300, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonAtras.setText("Salir");
            botonAtras.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonAtras);

            botonAtras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();
                    Hide();
                    LoginTurista.GetInstance().Show();
                    UsuarioController.LogOut();
                }
            });
        }

        // Add components
        {
            components = new ArrayList<JComponent>();
            components.add(botonPerfil);
            components.add(botonViajes);
            components.add(botonPagos);
            components.add(botonReviews);
            components.add(botonGuias);
            components.add(botonAtras);
        }
    }

    private void Reset() {

        botonViajes.setForeground(Color.DARK_GRAY.darker());
        botonPagos.setForeground(Color.DARK_GRAY.darker());
        botonReviews.setForeground(Color.DARK_GRAY.darker());
        botonGuias.setForeground(Color.DARK_GRAY.darker());
        botonPerfil.setForeground(Color.DARK_GRAY.darker());

        for (Pantalla pantalla : subpantallas){
            pantalla.Hide();
        }
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }
}
