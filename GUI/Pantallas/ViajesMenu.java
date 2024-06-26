package GUI.Pantallas;

import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.ViajePackage.Controller.ViajeDTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViajesMenu extends Pantalla {
    private static int classId = -1;

    private JComboBox<ViajeDTO> viajes;

    public ViajesMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        viajes = new JComboBox<>();
        viajes.setBounds((WINDOW_WIDTH / 2) , (WINDOW_HEIGHT / 2), 400, 40);
        viajes.setOpaque(false);
        viajes.setBackground(mainBackgroundColor);
        container.add(viajes);

        components = new ArrayList<>();
        components.add(viajes);
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void Actualizar(ArrayList<ViajeDTO> viajes) {
    }
}
