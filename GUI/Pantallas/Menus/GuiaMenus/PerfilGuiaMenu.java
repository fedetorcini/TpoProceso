package GUI.Pantallas.Menus.GuiaMenus;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.UsuarioPackage.ControllerPackage.UsuarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PerfilGuiaMenu extends Pantalla {

    private static int classId = -1;

    private JComboBox<String> sexoBox;
    private JGradientButton botonConfirmar;
    private FedeJTextField  nombreTexto;
    private FedeJTextField  apellidoTexto;
    private FedeJTextField  telefonoTexto;
    private FedeJTextField  dniTexto;


    public PerfilGuiaMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor,secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

        // Boton Confirmar
        {
            botonConfirmar = new JGradientButton(mainColor, secondary);
            botonConfirmar.setBounds((WINDOW_WIDTH / 2) - 50, (WINDOW_HEIGHT / 2) + 200, 100, 50);
            botonConfirmar.setText("Enviar");
            botonConfirmar.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonConfirmar);

            botonConfirmar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombre = nombreTexto.getText();
                    String apellido = apellidoTexto.getText();
                    String sexo = (String) sexoBox.getSelectedItem();
                    int telefono = Integer.parseInt(telefonoTexto.getText());
                    int dni = Integer.parseInt(dniTexto.getText());
                    UsuarioController uc = new UsuarioController();
                    uc.UpdateGuia(nombre, apellido, sexo, telefono, dni);
                    Hide();
                }
            });
        }

        // Create Form
        {
            nombreTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 50, 200, 40, "Ingresar Nombre");
            container.add(nombreTexto);
            apellidoTexto = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2) - 50, 200, 40, "Ingreasar Apellido");
            container.add(apellidoTexto);
            telefonoTexto = new FedeJTextField((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2), 200, 40, "Ingresar Telefono");
            container.add(telefonoTexto);
            dniTexto = new FedeJTextField((WINDOW_WIDTH / 2), (WINDOW_HEIGHT / 2), 200, 40, "Ingreasar Dni");
            container.add(dniTexto);

            sexoBox = new JComboBox<String>();
            sexoBox.setBounds((WINDOW_WIDTH / 2) - 100, (WINDOW_HEIGHT / 2) + 50, 200, 40);
            sexoBox.setOpaque(false);
            sexoBox.setBackground(mainBackgroundColor);
            sexoBox.addItem("Masculino");
            sexoBox.addItem("Femenino");
            container.add(sexoBox);
        }

        // Add components
        {
            components = new ArrayList<JComponent>();
            components.add(botonConfirmar);
            components.add(nombreTexto);
            components.add(apellidoTexto);
            components.add(telefonoTexto);
            components.add(dniTexto);
            components.add(sexoBox);
        }
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void SetUsuario(UsuarioDTO usuarioDTO) {
        nombreTexto.setDefault(usuarioDTO.GetNombre());
        apellidoTexto.setDefault(usuarioDTO.GetApellido());
        telefonoTexto.setDefault(Integer.toString(usuarioDTO.GetTelefono()));
        dniTexto.setDefault(Integer.toString(usuarioDTO.GetDni()));
        sexoBox.setSelectedItem(usuarioDTO.GetSexo());
    }
}
