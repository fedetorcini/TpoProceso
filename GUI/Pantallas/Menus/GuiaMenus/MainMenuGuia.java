package GUI.Pantallas.Menus.GuiaMenus;

import GUI.JGradientButton;
import GUI.Pantallas.Login.LoginGuia;
import GUI.Pantallas.Menus.TuristaMenus.ReseñasMenu;
import GUI.Pantallas.Menus.TuristaMenus.ViajesMenu;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.ReseñaDTO;
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
    private JGradientButton botonReviews;

    private JGradientButton botonAtras;

    public MainMenuGuia(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;
        subpantallas = new ArrayList<Pantalla>();

        // Boton Perfil
        {
            botonPerfilGuia = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonPerfilGuia.setBounds(0, (WINDOW_HEIGHT / 2) - 400, 225, 50);
            botonPerfilGuia.setText("Perfil");
            botonPerfilGuia.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonPerfilGuia);

            botonPerfilGuia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();

                    botonPerfilGuia.setForeground(mainBackgroundColor.brighter());

                    GuiaDTO guiaDTO = UsuarioController.GetLoggedGuia();

                    PerfilGuiaMenu perfil = (PerfilGuiaMenu) PerfilGuiaMenu.GetInstance();
                    subpantallas.add(perfil);
                    perfil.SetUsuario(guiaDTO);
                    perfil.Show();
                }
            });
        }

        // Boton Viajes
        {
            botonViajesHechos = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonViajesHechos.setBounds(225, (WINDOW_HEIGHT / 2) - 400, 225, 50);
            botonViajesHechos.setText("Viajes");
            botonViajesHechos.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonViajesHechos);

            botonViajesHechos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();

                    botonViajesHechos.setForeground(mainBackgroundColor.brighter());

                    ViajesGuiaMenu viajesMenu = (ViajesGuiaMenu) ViajesGuiaMenu.GetInstance();

                    if (!subpantallas.contains(viajesMenu))
                        subpantallas.add(viajesMenu);
                    viajesMenu.Show();

                    ViajeController vc = new ViajeController();
                    viajesMenu.Actualizar(vc.GetViajesDeGuia(UsuarioController.GetLoggedGuia()));
                }
            });
        }

        // Boton Reviews
        {
            botonReviews = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonReviews.setBounds(450, (WINDOW_HEIGHT / 2) - 400, 225, 50);
            botonReviews.setText("Reviews");
            botonReviews.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonReviews);

            botonReviews.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();
                    ReseñasGuiaMenu reseñasMenu = (ReseñasGuiaMenu)ReseñasGuiaMenu.GetInstance();
                    botonReviews.setForeground(mainBackgroundColor.brighter());

                    if (!subpantallas.contains(reseñasMenu))
                        subpantallas.add(reseñasMenu);

                    ArrayList<ReseñaDTO> reseñaDtos = UsuarioController.GetReseñasByGuia(UsuarioController.GetLoggedGuia());

                    reseñasMenu.Actualizar(reseñaDtos);
                    reseñasMenu.Show();
                }
            });
        }

        // Boton Atras
        {
            botonAtras = new JGradientButton(mainBackgroundColor.darker(), mainBackgroundColor.darker());
            botonAtras.setBounds(900-225, (WINDOW_HEIGHT / 2) - 400, 225, 50);
            botonAtras.setText("Salir");
            botonAtras.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonAtras);

            botonAtras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reset();
                    Hide();
                    LoginGuia.GetInstance().Show();
                    UsuarioController.LogOut();
                }
            });
        }

        // Add components
        {
            components = new ArrayList<>();
            components.add(botonPerfilGuia);
            components.add(botonReviews);
            components.add(botonViajesHechos);
            components.add(botonAtras);
        }
    }

    private void Reset() {

        botonViajesHechos.setForeground(Color.DARK_GRAY.darker());
        botonReviews.setForeground(Color.DARK_GRAY.darker());
        botonPerfilGuia.setForeground(Color.DARK_GRAY.darker());

        for (Pantalla pantalla : subpantallas){
            pantalla.Hide();
        }
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }
}
