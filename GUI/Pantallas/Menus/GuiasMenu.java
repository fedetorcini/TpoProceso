package GUI.Pantallas.Menus;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.LoginTurista;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.FiltroGuia;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.UsuarioPackage.Guia;
import src.UsuarioPackage.Turista;
import src.ViajePackage.Controller.ReseñaDTO;
import src.ViajePackage.Controller.ViajeDTO;
import src.ViajePackage.Reseña;
import src.ViajePackage.Viaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class GuiasMenu extends Pantalla {private static int classId = -1;
    private JGradientButton darReseña;
    private JGradientButton verReseñas;
    private FedeJTextField textoReseña;
    private ArrayList<JLabel> resenias;

    private JComboBox<GuiaDTO> guias;
    public GuiasMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        {
            guias = new JComboBox<GuiaDTO>();
            guias.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
            guias.setOpaque(false);
            guias.setBackground(mainBackgroundColor);
            container.add(guias);
        }

        {
            textoReseña = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2), 400, 150, "Escriba reseña");
            container.add(textoReseña);
        }

        {
            darReseña = new JGradientButton(Color.RED.darker(), secondary);
            darReseña.setBounds((WINDOW_WIDTH / 2) + 200, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            darReseña.setText("Dar Reseña");
            darReseña.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(darReseña);

            darReseña.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener datos para la reseña
                    GuiaDTO guiaSeleccionado = (GuiaDTO) guias.getSelectedItem();
                    String reseñaText = textoReseña.getText();
                    TuristaDTO turistaDTO = UsuarioController.GetLoggedTurista(); // Asumiendo que obtienes el turista logueado

                    // Crear un objeto ReseñaDTO y guardar la reseña
                    ReseñaDTO reseñaDTO = new ReseñaDTO();
                    reseñaDTO.SetGuia(guiaSeleccionado);
                    reseñaDTO.SetTexto(reseñaText);
                    reseñaDTO.SetTurista(turistaDTO);
                    reseñaDTO.SetEstrellas(5);
                    reseñaDTO.SetViaje(new ViajeDTO(new Viaje()));
                    Reseña reseña = new Reseña();
                    reseña.RegistrarReseña(reseñaDTO);
                    JOptionPane.showMessageDialog(null, "Reseña guardada con éxito.");

                    // Limpiar el campo de texto después de guardar la reseña
                }
            });





            {
                verReseñas = new JGradientButton(Color.RED.darker(), secondary);
                verReseñas.setBounds((WINDOW_WIDTH / 2) -50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
                verReseñas.setText("Ver Reseñas");
                verReseñas.setFont(new Font("Serif", Font.BOLD, 15));
                container.add(verReseñas);

                verReseñas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginTurista.GetInstance().Show(); // Mostrar pantalla de login (suponiendo que esta parte funciona bien)

                        GuiaDTO guiaSeleccionado = (GuiaDTO) guias.getSelectedItem(); // Obtener el guía seleccionado del JComboBox

                        ArrayList<ReseñaDTO> reseñas = UsuarioController.getReseñas(guiaSeleccionado); // Obtener las reseñas del guía

                        // Limpiar el contenedor antes de agregar las nuevas reseñas
                        container.removeAll();

                        // Crear y agregar los JLabels de las reseñas al contenedor
                        int y = 100; // Posición vertical inicial de los JLabels
                        for (ReseñaDTO reseñaDTO : reseñas) {
                            JLabel jLabel = new JLabel();
                            jLabel.setText(reseñaDTO.GetTexto()); // Establecer el texto de la reseña en el JLabel
                            jLabel.setBounds((WINDOW_WIDTH / 2) - 200, y, 400, 30); // Ajustar posición y tamaño según sea necesario
                            container.add(jLabel); // Agregar el JLabel al contenedor
                            y += 40; // Incremento para la siguiente posición vertical
                        }

                        // Revalidar y repintar el contenedor para que se muestren los cambios
                        container.revalidate();
                        container.repaint();
                    }
                });




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

