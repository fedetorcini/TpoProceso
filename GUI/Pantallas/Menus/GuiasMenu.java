package GUI.Pantallas.Menus;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.ReseñaDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GuiasMenu extends Pantalla {

    private static int classId = -1;

    private JComboBox<GuiaDTO> guias;

    private JLabel guiaBanner;
    private JLabel ubicacionBanner;
    private JLabel precioBanner;
    private JLabel calificacionBanner;
    private JLabel idiomaBanner;

    private JComboBox<ReseñaDTO> resañaBox;

    private JLabel reseñaBanner;
    private JLabel calificacionReseñaBanner;

    public GuiasMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        // Guias Combo Box
        {
            guias = new JComboBox<>();
            guias.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
            guias.setOpaque(false);
            guias.setBackground(mainBackgroundColor);
            container.add(guias);

            guias.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calificacionReseñaBanner.setText(" ");
                    reseñaBanner.setText(" ");
                    GuiaDTO guiaDto = (GuiaDTO) guias.getSelectedItem();

                    if (guiaDto != null) {
                        // Set Banners
                        {
                            guiaBanner.setText(guiaDto.toString());
                            ubicacionBanner.setText(guiaDto.GetLocacion());
                            precioBanner.setText("$" + guiaDto.GetCostoTotal());
                            calificacionBanner.setText("Calificacion : " + guiaDto.getCalificacion());
                            // Set Idiomas
                            {
                                String idiomas = "<html><h3>Idiomas : ";
                                for (String idioma : guiaDto.getIdiomas()) {
                                    idiomas += idioma + " | ";
                                }
                                idiomaBanner.setText(idiomas);
                            }

                            resañaBox.removeAllItems();
                            ArrayList<ReseñaDTO> reseñasDtos = UsuarioController.GetReseñasByGuia(guiaDto);
                            for(ReseñaDTO reseñaDto : reseñasDtos){
                                resañaBox.addItem(reseñaDto);
                            }
                        }
                    }
                }
            });
        }

        // Reseñas Combo Box
        {
            resañaBox = new JComboBox<>();
            resañaBox.setBounds(WINDOW_WIDTH - (WINDOW_WIDTH / 4) - 150, (WINDOW_HEIGHT / 2) - 150, 300, 40);
            resañaBox.setOpaque(false);
            resañaBox.setBackground(mainBackgroundColor);
            container.add(resañaBox);

            resañaBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ReseñaDTO reseñaDTO = (ReseñaDTO) resañaBox.getSelectedItem();

                    if (reseñaDTO != null) {
                        float calificacion = reseñaDTO.GetEstrellas();
                        if (calificacion != -1) {
                            DecimalFormat df = new DecimalFormat("0.00");
                            calificacionReseñaBanner.setText("Calificacion : " + df.format(calificacion));
                            reseñaBanner.setText(reseñaDTO.GetTexto());
                        }
                        else {
                            calificacionReseñaBanner.setText("Aun no se ha dejado una Reseña");
                            reseñaBanner.setText(" ");
                        }
                    }
                }
            });
        }

        // Reseña Banner
        {
            reseñaBanner = new JLabel(" ", SwingConstants.CENTER);
            reseñaBanner.setBounds(WINDOW_WIDTH - (WINDOW_WIDTH / 4) - 200, (WINDOW_HEIGHT / 2) + 50, 400, 100);
            reseñaBanner.setOpaque(false);
            reseñaBanner.setFont(new Font("Serif", Font.ITALIC, 13));
            container.add(reseñaBanner);
        }

        // Calificacion Reseña Banner
        {
            calificacionReseñaBanner = new JLabel(" ", SwingConstants.CENTER);
            calificacionReseñaBanner.setBounds(WINDOW_WIDTH - (WINDOW_WIDTH / 4) - 200, (WINDOW_HEIGHT / 2) - 50, 400, 100);
            calificacionReseñaBanner.setOpaque(false);
            calificacionReseñaBanner.setFont(new Font("Serif", Font.ITALIC, 30));
            container.add(calificacionReseñaBanner);
        }

        // Guia Banner
        {
            guiaBanner = new JLabel(" ", SwingConstants.CENTER);
            guiaBanner.setBounds((WINDOW_WIDTH/4) - 100, 300, 200, 50);
            guiaBanner.setOpaque(true);
            guiaBanner.setBackground(mainBackgroundColor);
            guiaBanner.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(guiaBanner);
        }

        // Ubicacion Banner
        {
            ubicacionBanner = new JLabel(" ", SwingConstants.CENTER);
            ubicacionBanner.setBounds((WINDOW_WIDTH/4) - 250, 200, 500, 50);
            ubicacionBanner.setOpaque(true);
            ubicacionBanner.setBackground(mainBackgroundColor);
            ubicacionBanner.setFont(new Font("Serif", Font.BOLD, 24));
            container.add(ubicacionBanner);
        }

        // Precio Banner
        {
            precioBanner = new JLabel(" ", SwingConstants.CENTER);
            precioBanner.setBounds((WINDOW_WIDTH/4) - 100, 400, 200, 75);
            precioBanner.setOpaque(true);
            precioBanner.setBackground(mainBackgroundColor);
            precioBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(precioBanner);
        }

        // Calificacion Banner
        {
            calificacionBanner = new JLabel(" ", SwingConstants.CENTER);
            calificacionBanner.setBounds((WINDOW_WIDTH/4) - 100, 500, 200, 75);
            calificacionBanner.setOpaque(true);
            calificacionBanner.setBackground(mainBackgroundColor);
            calificacionBanner.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(calificacionBanner);
        }

        // Idioma Banner
        {
            idiomaBanner = new JLabel(" ", SwingConstants.CENTER);
            idiomaBanner.setBounds((WINDOW_WIDTH/4) - 100, 350, 200, 75);
            idiomaBanner.setOpaque(false);
            idiomaBanner.setBackground(mainBackgroundColor);
            idiomaBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(idiomaBanner);
        }

        // Componentes
        {
            components = new ArrayList<>();
            components.add(guias);
            components.add(ubicacionBanner);
            components.add(precioBanner);
            components.add(calificacionBanner);
            components.add(idiomaBanner);
            components.add(guiaBanner);
            components.add(resañaBox);
            components.add(reseñaBanner);
            components.add(calificacionReseñaBanner);
        }

    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void Actualizar(ArrayList<GuiaDTO> guiasDtos) {
        guias.removeAllItems();

        for(GuiaDTO guiaDto : guiasDtos){
            guias.addItem(guiaDto);
        }
    }
}

