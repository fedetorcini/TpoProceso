package GUI.Pantallas.Menus.TuristaMenus;

import GUI.Pantallas.Pantalla;
import src.PagoPackage.PagoDTO;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PagosMenu extends Pantalla {

    private static int classId=-1;

    private JComboBox <PagoDTO> pagos;

    public PagosMenu(Pantalla pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(pantalla.GetId(), mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

        // Pagos Box
        {
            pagos = new JComboBox<>();
            pagos.setBounds((WINDOW_WIDTH / 2) - 200, (WINDOW_HEIGHT / 2) - 300, 400, 40);
            pagos.setOpaque(false);
            pagos.setBackground(mainBackgroundColor);
            container.add(pagos);
        }

        components = new ArrayList<>();
        components.add(pagos);
    }

    public static Pantalla GetInstance() { return Pantalla.GetById(classId);}

    public void Actualizar(ArrayList<PagoDTO> pagosDtos) {
        pagos.removeAllItems();

        for(PagoDTO pagoDTO : pagosDtos){
            pagos.addItem(pagoDTO);
        }
    }
}
