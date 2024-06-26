package GUI.Pantallas;

import java.awt.*;

public class Main extends Pantalla{

    private static Pantalla instance = null;
    private static int classId = -1;

    public Main(Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        super(-1, mainColor, secondary, mainBackgroundColor, deltaTime, windowWidth, windowHeight, container);

        classId = id;

    }

    public static Pantalla GetInstance() {
        return Pantalla.GetById(classId);
    }

    @Override
    public void Show() {

    }
    @Override
    public void Hide() {

    }
}
