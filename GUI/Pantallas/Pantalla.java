package GUI.Pantallas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pantalla {

    protected static HashMap<Integer, Pantalla> pantallas = new HashMap<Integer, Pantalla>();
    protected ArrayList<JComponent> components;
    protected int previa;
    protected int siguiente;

    protected long deltaTime;
    protected Color mainColor;
    protected Color secondary;
    protected Color mainBackgroundColor;

    protected Container container;

    protected int WINDOW_HEIGHT;
    protected int WINDOW_WIDTH;

    protected int id;
    protected static int IDs = 0;

    public Pantalla (int pantalla, Color mainColor, Color secondary, Color mainBackgroundColor, long deltaTime, int windowWidth, int windowHeight, Container container) {
        this.WINDOW_HEIGHT = windowHeight;
        this.WINDOW_WIDTH = windowWidth;

        this.previa = pantalla;

        this.deltaTime = deltaTime;
        this.mainColor = mainColor;
        this.secondary = secondary;
        this.mainBackgroundColor = mainBackgroundColor;
        this.container = container;

        this.id = IDs;
        IDs++;

        pantallas.put(id, this);
        System.out.println("Pantalla creada con exito ID: " + id);
    }

    protected static Pantalla GetById(int classId) {
        return pantallas.get(classId);
    }

    public void Show() {
        for (JComponent component : components)
        {
            component.show();
        }
    }

    public void Hide() {
        for (JComponent component : components) {
            component.hide();
        }
    }

    protected int GetId() {
        return id;
    }
}
