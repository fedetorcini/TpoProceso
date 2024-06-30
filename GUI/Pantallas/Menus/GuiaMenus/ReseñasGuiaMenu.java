package GUI.Pantallas.Menus.GuiaMenus;

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

public class ReseñasGuiaMenu extends Pantalla {

    private static int classId = -1;

    private JComboBox<ReseñaDTO> resañaBox;

    private JLabel reseñaBanner;
    private JLabel calificacionBanner;
    private JLabel turistaBanner;

    public ReseñasGuiaMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
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

        // Turista Banner
        {
            turistaBanner = new JLabel(" ", SwingConstants.CENTER);
            turistaBanner.setBounds((WINDOW_WIDTH/4) - 100, 400, 200, 75);
            turistaBanner.setOpaque(true);
            turistaBanner.setBackground(mainBackgroundColor);
            turistaBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(turistaBanner);
        }

        // Componentes
        {
            components = new ArrayList<>();
            components.add(resañaBox);
            components.add(calificacionBanner);
            components.add(turistaBanner);
            components.add(reseñaBanner);
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
