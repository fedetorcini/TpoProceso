package GUI.Pantallas;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import src.UsuarioPackage.ControllerPackage.FiltroGuia;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.UsuarioPackage.Guia;
import src.ViajePackage.Controller.ViajeDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ListaGuias extends Pantalla{
    private static int classId = -1;
    private JLabel reseñas;
    private JGradientButton darReseña;
    private JGradientButton verReseñas;
    private FedeJTextField textoReseña;

    private JComboBox<GuiaDTO> guias;
    public ListaGuias(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        /*{titulo = new JLabel("temp name", SwingConstants.CENTER);
        titulo.setBounds((WINDOW_WIDTH/2) - 100, 200, 200, 50);
        titulo.setOpaque(true);
        titulo.setBackground(mainBackgroundColor.darker());
        titulo.setText("Listado de Guias");
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        container.add(titulo);
        }*/

    //Listado de guias

        {
            guias = new JComboBox<GuiaDTO>();
            guias.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
            guias.setOpaque(false);
            guias.setBackground(mainBackgroundColor);
            container.add(guias);
        }

        {
            darReseña = new JGradientButton(Color.RED.darker(), secondary);
            darReseña.setBounds((WINDOW_WIDTH / 2) + 50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            darReseña.setText("Dar Reseña");
            darReseña.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(darReseña);

            darReseña.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    LoginTurista.GetInstance().Show();
                }
            });





            {
                verReseñas = new JGradientButton(Color.RED.darker(), secondary);
                verReseñas.setBounds((WINDOW_WIDTH / 2) + 50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
                verReseñas.setText("Ver Reseñas");
                verReseñas.setFont(new Font("Serif", Font.BOLD, 15));
                container.add(verReseñas);

                verReseñas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginTurista.GetInstance().Show();
                        reseñas = new JLabel();
                        reseñas.setText(UsuarioController.getReseñas((GuiaDTO) guias.getSelectedItem()).get(0).toString());
                    }
                });

            textoReseña = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2), 400, 150, "Escriba reseña");
            container.add(textoReseña);



        components = new ArrayList<>();
        components.add(darReseña);
        components.add(guias);
        components.add(textoReseña);
        components.add(verReseñas);



    }
    }
    }
    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void Actualizar(ArrayList<GuiaDTO> guiasDTO) {
        guias.removeAllItems();
        for(GuiaDTO guiaDTO : guiasDTO){
            guias.addItem(guiaDTO);
        }
    }
}

