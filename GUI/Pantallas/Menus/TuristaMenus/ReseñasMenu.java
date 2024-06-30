package GUI.Pantallas.Menus.TuristaMenus;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.ReseñaDTO;
import src.ViajePackage.Controller.ViajeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReseñasMenu extends Pantalla {

    private static int classId = -1;

    private JComboBox<ReseñaDTO> resañaBox;

    private JLabel reseñaBanner;
    private JLabel calificacionBanner;
    private JLabel precioBanner;

    private FedeJTextField reseñaTexto;
    private FedeJTextField calificacionTexto;
    private JGradientButton crearReseñaBoton;

    public ReseñasMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        // Reseñas Combo Box
        {
            resañaBox = new JComboBox<>();
            resañaBox.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
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
                            calificacionBanner.setText("Calificacion : " + df.format(calificacion));
                            reseñaBanner.setText(reseñaDTO.GetTexto());
                        }
                        else {
                            calificacionBanner.setText("Aun no se a dejado una Reseña");
                            reseñaBanner.setText(" ");
                        }
                    }
                }
            });
        }

        // Reseña Banner
        {
            reseñaBanner = new JLabel(" ", SwingConstants.CENTER);
            reseñaBanner.setBounds((WINDOW_WIDTH/2) - 200, 300, 400, 100);
            reseñaBanner.setOpaque(false);
            reseñaBanner.setFont(new Font("Serif", Font.ITALIC, 13));
            container.add(reseñaBanner);
        }

        // Calificacion Banner
        {
            calificacionBanner = new JLabel(" ", SwingConstants.CENTER);
            calificacionBanner.setBounds((WINDOW_WIDTH/2) - 200, 200, 400, 100);
            calificacionBanner.setOpaque(false);
            calificacionBanner.setFont(new Font("Serif", Font.ITALIC, 30));
            container.add(calificacionBanner);
        }

        // Guia Banner
        {
            precioBanner = new JLabel(" ", SwingConstants.CENTER);
            precioBanner.setBounds((WINDOW_WIDTH/4) - 100, 400, 200, 75);
            precioBanner.setOpaque(true);
            precioBanner.setBackground(mainBackgroundColor);
            precioBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(precioBanner);
        }

        // Reseña Mensaje
        {
            reseñaTexto = new FedeJTextField((WINDOW_WIDTH/2) - 150, 545, 300, 40, "Ingresar reseña");
            container.add(reseñaTexto);
        }

        // Calificacion Mensaje
        {
            calificacionTexto = new FedeJTextField((WINDOW_WIDTH/2) - 150, 585, 200, 40, "Ingresar calificacion");
            container.add(calificacionTexto);
        }

        // Boton Enviar Reseña
        {
            crearReseñaBoton = new JGradientButton(mainColor, secondary);
            crearReseñaBoton.setBounds((WINDOW_WIDTH/2) + 50, 585, 100, 40);
            crearReseñaBoton.setText("Enviar");
            crearReseñaBoton.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(crearReseñaBoton);

            crearReseñaBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    ReseñaDTO reseñaDto = (ReseñaDTO) resañaBox.getSelectedItem();
                    reseñaDto.SetEstrellas(Float.parseFloat(calificacionTexto.getText()));
                    reseñaDto.SetTexto(reseñaTexto.getText());

                    ViajeController viajeController = new ViajeController();
                    viajeController.DejarReseña(reseñaDto);

                    ArrayList<ReseñaDTO> reseñasDtos = UsuarioController.GetReseñasByTurista(UsuarioController.GetLoggedTurista());
                    Actualizar(reseñasDtos);
                }
            });
        }

        // Componentes
        {
            components = new ArrayList<>();
            components.add(resañaBox);
            components.add(calificacionBanner);
            components.add(calificacionTexto);
            components.add(precioBanner);
            components.add(reseñaBanner);
            components.add(reseñaTexto);
            components.add(crearReseñaBoton);
        }

    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void Actualizar(ArrayList<ReseñaDTO> reseñaDTOS) {
        resañaBox.removeAllItems();

        for(ReseñaDTO reseñaDTO : reseñaDTOS){
            resañaBox.addItem(reseñaDTO);
        }
    }
}
