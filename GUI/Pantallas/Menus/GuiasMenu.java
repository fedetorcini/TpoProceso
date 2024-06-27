package GUI.Pantallas.Menus;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Login.LoginTurista;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiasMenu extends Pantalla {

    private static int classId = -1;

    private JLabel reseñas;

    private JGradientButton darReseñaBoton;
    private JGradientButton verReseñasBoton;
    private FedeJTextField textoReseña;

    private JComboBox<GuiaDTO> guias;

    public GuiasMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        //Listado de guias
        {
            guias = new JComboBox<GuiaDTO>();
            guias.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
            guias.setOpaque(false);
            guias.setBackground(mainBackgroundColor);
            container.add(guias);
        }

        // Dar reseña Boton
        {
            darReseñaBoton = new JGradientButton(Color.RED.darker(), secondary);
            darReseñaBoton.setBounds((WINDOW_WIDTH / 2) + 50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            darReseñaBoton.setText("Dar Reseña");
            darReseñaBoton.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(darReseñaBoton);

            darReseñaBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    LoginTurista.GetInstance().Show();
                }
            });
        }

        // Ver reseñas Boton
        {
            verReseñasBoton = new JGradientButton(Color.RED.darker(), secondary);
            verReseñasBoton.setBounds((WINDOW_WIDTH / 2) + 50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            verReseñasBoton.setText("Ver Reseñas");
            verReseñasBoton.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(verReseñasBoton);

            verReseñasBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoginTurista.GetInstance().Show();
                    reseñas = new JLabel();
                    reseñas.setText(UsuarioController.getReseñas((GuiaDTO) guias.getSelectedItem()).get(0).toString());
                }
            });
        }

        // Texto Reserva
        {
            textoReseña = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2), 400, 150, "Escriba reseña");
            container.add(textoReseña);
        }

        // Componentes
        {
            components = new ArrayList<>();
            components.add(darReseñaBoton);
            components.add(guias);
            components.add(textoReseña);
            components.add(verReseñasBoton);
        }
    }

    public static Pantalla GetInstance() { return Pantalla.GetById(classId);}

    public void Actualizar(ArrayList<GuiaDTO> guiasDTO) {
        guias.removeAllItems();
        for(GuiaDTO guiaDTO : guiasDTO){
            guias.addItem(guiaDTO);
        }
    }
}

