package GUI.Pantallas.Menus;

import GUI.JGradientButton;
import GUI.Pantallas.Login.LoginTurista;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.ViajeController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuGuia extends Pantalla {

    private static int classId = -1;

    private ArrayList<Pantalla> subpantallas;

    private JGradientButton botonPerfilGuia;
    private JGradientButton botonViajesHechos;
    private JGradientButton botonCobros;
    private JGradientButton botonReviews;
    private JGradientButton botonViajesDisponibles;

    private JGradientButton botonAtras;

    public MainMenuGuia(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;
        subpantallas = new ArrayList<Pantalla>();

        // Boton Perfil
        {
            botonPerfilGuia = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonPerfilGuia.setBounds((WINDOW_WIDTH / 2) - 450, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonPerfilGuia.setText("Perfil");
            botonPerfilGuia.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonPerfilGuia);

            botonPerfilGuia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();

                    botonPerfilGuia.setForeground(mainBackgroundColor.brighter());

                    GuiaDTO guiaDTO = UsuarioController.GetLoggedGuia();

                    PerfilMenuGuia perfilGuia = (PerfilMenuGuia) PerfilMenuGuia.GetInstance();
                    subpantallas.add(perfilGuia);
                    perfilGuia.SetUsuario(guiaDTO);
                    perfilGuia.Show();
                }
            });
        }

        // Boton Viajes
        {
            botonViajesHechos = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonViajesHechos.setBounds((WINDOW_WIDTH / 2) - 300, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonViajesHechos.setText("Viajes");
            botonViajesHechos.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonViajesHechos);

            botonViajesHechos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();

                    botonViajesHechos.setForeground(mainBackgroundColor.brighter());

                    ViajesMenu viajesMenu = (ViajesMenu) ViajesMenu.GetInstance();

                    if (!subpantallas.contains(viajesMenu))
                        subpantallas.add(viajesMenu);
                    viajesMenu.Show();

                    ViajeController vc = new ViajeController();
                    viajesMenu.Actualizar(vc.GetViajesDeGuia(UsuarioController.GetLoggedGuia()));
                }
            });
        }

        // Boton Pagos
        {
            botonCobros = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonCobros.setBounds((WINDOW_WIDTH / 2) - 150, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonCobros.setText("Cobros");
            botonCobros.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonCobros);

            botonCobros.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();

                    botonCobros.setForeground(mainBackgroundColor.brighter());

                    PagosMenu pagosMenu = (PagosMenu) PagosMenu.GetInstance();
                    if (!subpantallas.contains(pagosMenu))
                        subpantallas.add(pagosMenu);
                    pagosMenu.Show();
                    pagosMenu.Actualizar(UsuarioController.GetCobrosByGuia(UsuarioController.GetLoggedGuia()));
                }
            });
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
            botonViajesDisponibles = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());

            botonViajesDisponibles.setBounds((WINDOW_WIDTH / 2) + 150, (WINDOW_HEIGHT / 2) - 400, 150, 50);
            botonViajesDisponibles.setText("Viajes disponibles");
            botonViajesDisponibles.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonViajesDisponibles);
            botonViajesDisponibles.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();
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
            components = new ArrayList<>();
            components.add(botonPerfilGuia);
            components.add(botonViajesDisponibles);
            components.add(botonCobros);
            components.add(botonReviews);
            components.add(botonViajesHechos);
            components.add(botonAtras);
        }
    }

    private void Reset() {

        botonViajesHechos.setForeground(Color.DARK_GRAY.darker());
        botonCobros.setForeground(Color.DARK_GRAY.darker());
        botonReviews.setForeground(Color.DARK_GRAY.darker());
        botonViajesDisponibles.setForeground(Color.DARK_GRAY.darker());
        botonPerfilGuia.setForeground(Color.DARK_GRAY.darker());

        for (Pantalla pantalla : subpantallas){
            pantalla.Hide();
        }
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }
}
