package GUI.Pantallas;

import GUI.JGradientButton;
import src.UsuarioPackage.ControllerPackage.FiltroGuia;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.ViajeDTO;
import src.ViajePackage.Viaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViajesMenu extends Pantalla {
    private static int classId = -1;

    private JComboBox<ViajeDTO> viajes;

    private JGradientButton botonCrear;

    public ViajesMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        // Viajes Combo Box
        {
            viajes = new JComboBox<>();
            viajes.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
            viajes.setOpaque(false);
            viajes.setBackground(mainBackgroundColor);
            container.add(viajes);

            viajes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ViajeDTO viaje = (ViajeDTO) viajes.getSelectedItem();
                    if (viaje != null)
                    {
                        UsuarioController usuarioController = new UsuarioController();
                        FiltroGuia filtro = new FiltroGuia();
                        filtro.SetId(viaje.GetGuiaId());
                        ArrayList<GuiaDTO> guias = usuarioController.GetGuia(filtro);
                    }
                }
            });
        }

        // Boton Crear
        {
            botonCrear = new JGradientButton(mainColor, secondary);
            botonCrear.setBounds((WINDOW_WIDTH / 2) - 150, (WINDOW_HEIGHT / 2) + 250, 300, 50);
            botonCrear.setText(" Nuevo Viaje ");
            botonCrear.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonCrear);

            botonCrear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
        }

        // Componentes
        {
            components = new ArrayList<>();
            components.add(viajes);
            components.add(botonCrear);
        }

    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    public void Actualizar(ArrayList<ViajeDTO> viajesDtos) {
        viajes.removeAllItems();

        for(ViajeDTO viajeDto : viajesDtos){
            viajes.addItem(viajeDto);
        }
    }
}
