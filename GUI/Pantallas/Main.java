package GUI.Pantallas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends Pantalla{

    private static int classId = -1;

    public Main(Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(-1, mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);
        classId = id;

        components = new ArrayList<JComponent>();
    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }
}
