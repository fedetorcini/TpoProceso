package GUI.Pantallas.Menus;

import GUI.JGradientButton;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.FiltroGuia;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.ViajeController;
import src.ViajePackage.Controller.ViajeDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevoViajeMenu extends Pantalla {

    private static int classId = -1;

    private JComboBox<GuiaDTO> guiaBox;

    private JGradientButton botonConfirmar;
    private JGradientButton botonAtras;

    private JLabel ubicacionBanner;
    private JLabel precioBanner;
    private JLabel idiomaBanner;

    public NuevoViajeMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container){
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

        // Boton Confirmar
        {
            botonConfirmar = new JGradientButton(mainColor, secondary);
            botonConfirmar.setBounds((WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            botonConfirmar.setText("Enviar");
            botonConfirmar.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonConfirmar);

            botonConfirmar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();

                    GuiaDTO guia = (GuiaDTO) guiaBox.getSelectedItem();
                    ViajeController vc = new ViajeController();
                    ViajeDTO viaje = vc.CrearViaje(UsuarioController.GetLoggedTurista(), guia);
                    vc.Reservar(viaje);
                    ViajesMenu viajeMenu = (ViajesMenu) ViajesMenu.GetInstance();
                    viajeMenu.Actualizar(vc.GetViajesDeTurista(UsuarioController.GetLoggedTurista()));
                    viajeMenu.Show();
                }
            });
        }

        // Boton Atras
        {
            botonAtras = new JGradientButton(Color.RED.darker(), secondary);
            botonAtras.setBounds((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) + 200, 100, 50);
            botonAtras.setText("Atras");
            botonAtras.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonAtras);

            botonAtras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    ViajesMenu.GetInstance().Show();
                }
            });
        }

        // Ubicacion Banner
        {
            ubicacionBanner = new JLabel(" ", SwingConstants.CENTER);
            ubicacionBanner.setBounds((WINDOW_WIDTH/2) - 250, 200, 500, 50);
            ubicacionBanner.setOpaque(true);
            ubicacionBanner.setBackground(mainBackgroundColor);
            ubicacionBanner.setFont(new Font("Serif", Font.BOLD, 24));
            container.add(ubicacionBanner);
        }

        // Idioma Banner
        {
            idiomaBanner = new JLabel(" ", SwingConstants.CENTER);
            idiomaBanner.setBounds((WINDOW_WIDTH/2) - 100, 350, 200, 75);
            idiomaBanner.setOpaque(false);
            idiomaBanner.setBackground(mainBackgroundColor);
            idiomaBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(idiomaBanner);
        }

        // Guia Combo Box
        {
            guiaBox = new JComboBox<>();
            guiaBox.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
            guiaBox.setOpaque(false);
            guiaBox.setBackground(mainBackgroundColor);
            container.add(guiaBox);

            guiaBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FiltroGuia filtro = new FiltroGuia();
                    GuiaDTO guiaDto = (GuiaDTO) guiaBox.getSelectedItem();
                    if (guiaDto != null)
                    {
                        filtro.SetNombre(guiaDto.GetNombre());
                        ArrayList<GuiaDTO> guias = UsuarioController.GetGuia(filtro);
                        GuiaDTO guia = guias.get(0);

                        // Set Banners
                        {
                            ubicacionBanner.setText(guia.GetLocacion());
                            precioBanner.setText("$" + guia.GetCostoTotal());

                            // Set Idiomas
                            {
                                String idiomas = "<html><h3>Idiomas : ";
                                for (String idioma : guia.getIdiomas()) {
                                    idiomas += idioma + " | ";
                                }
                                idiomaBanner.setText(idiomas);
                            }
                        }
                    }
                }
            });
        }

        // Precio Banner
        {
            precioBanner = new JLabel(" ", SwingConstants.CENTER);
            precioBanner.setBounds((WINDOW_WIDTH/2) - 100, 300, 200, 50);
            precioBanner.setOpaque(true);
            precioBanner.setBackground(mainBackgroundColor);
            precioBanner.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(precioBanner);
        }

        // Add components
        {
            components = new ArrayList<JComponent>();
            components.add(botonConfirmar);
            components.add(botonAtras);
            components.add(guiaBox);
            components.add(precioBanner);
            components.add(ubicacionBanner);
            components.add(idiomaBanner);
        }
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void Actualizar(ArrayList<GuiaDTO> guiaDtos) {
        guiaBox.removeAllItems();

        for(GuiaDTO guiaDto : guiaDtos){
            guiaBox.addItem(guiaDto);
        }
    }

}
