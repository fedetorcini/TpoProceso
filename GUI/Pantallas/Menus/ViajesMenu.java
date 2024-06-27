package GUI.Pantallas.Menus;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Pantalla;
import src.UsuarioPackage.ControllerPackage.FiltroGuia;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.MensajeDTO;
import src.ViajePackage.Controller.ViajeController;
import src.ViajePackage.Controller.ViajeDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViajesMenu extends Pantalla {
    private static int classId = -1;

    private JComboBox<ViajeDTO> viajes;

    private JLabel guiaBanner;
    private JLabel ubicacionBanner;
    private JLabel precioBanner;
    private JLabel idiomaBanner;
    private JLabel estadoBanner;

    private JLabel chatBanner;
    private FedeJTextField chatText;
    private JGradientButton enviarMensajeBoton;

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
                public void actionPerformed(ActionEvent e) {
                    ViajeDTO viaje = (ViajeDTO) viajes.getSelectedItem();

                    if (viaje != null) {
                        // Get Guia
                        UsuarioController usuarioController = new UsuarioController();
                        FiltroGuia filtro = new FiltroGuia();
                        filtro.SetId(viaje.GetGuiaId());
                        ArrayList<GuiaDTO> guias = usuarioController.GetGuia(filtro);
                        GuiaDTO guia = guias.get(0);

                        // Set Banners
                        {
                            guiaBanner.setText(guia.toString());
                            ubicacionBanner.setText(guia.GetLocacion());
                            precioBanner.setText("$" + viaje.GetPrecio());
                            estadoBanner.setText("Estado : " + viaje.GetEstado());

                            // Set Idiomas
                            {
                                String idiomas = "<html><h3>Idiomas : ";
                                for (String idioma : guia.getIdiomas()) {
                                    idiomas += idioma + " | ";
                                }
                                idiomaBanner.setText(idiomas);
                            }

                            // Set Mensajes
                            {
                                ViajeController vc = new ViajeController();
                                ArrayList<MensajeDTO> mensajesDtos = vc.GetChatDe(viaje);
                                String chatString = "<html>";
                                for (MensajeDTO mensaje : mensajesDtos) {
                                    chatString += (mensaje.GetEmisor() + " : " + mensaje.GetTexto() + "<br/>");
                                }
                                chatString += "</html>";
                                chatBanner.setText(chatString);
                            }
                        }

                    }
                }
            });
        }

        // Guia Banner
        {
            guiaBanner = new JLabel(" ", SwingConstants.CENTER);
            guiaBanner.setBounds((WINDOW_WIDTH/4) - 100, 300, 200, 50);
            guiaBanner.setOpaque(true);
            guiaBanner.setBackground(mainBackgroundColor);
            guiaBanner.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(guiaBanner);
        }

        // Ubicacion Banner
        {
            ubicacionBanner = new JLabel(" ", SwingConstants.CENTER);
            ubicacionBanner.setBounds((WINDOW_WIDTH/4) - 250, 200, 500, 50);
            ubicacionBanner.setOpaque(true);
            ubicacionBanner.setBackground(mainBackgroundColor);
            ubicacionBanner.setFont(new Font("Serif", Font.BOLD, 24));
            container.add(ubicacionBanner);
        }

        // Precio Banner
        {
            precioBanner = new JLabel(" ", SwingConstants.CENTER);
            precioBanner.setBounds((WINDOW_WIDTH/4) - 100, 400, 200, 75);
            precioBanner.setOpaque(true);
            precioBanner.setBackground(mainBackgroundColor);
            precioBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(precioBanner);
        }

        // Idioma Banner
        {
            idiomaBanner = new JLabel(" ", SwingConstants.CENTER);
            idiomaBanner.setBounds((WINDOW_WIDTH/4) - 100, 350, 200, 75);
            idiomaBanner.setOpaque(false);
            idiomaBanner.setBackground(mainBackgroundColor);
            idiomaBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(idiomaBanner);
        }

        // Estado Banner
        {
            estadoBanner = new JLabel(" ", SwingConstants.CENTER);
            estadoBanner.setBounds((WINDOW_WIDTH/4) - 100, 550, 200, 50);
            estadoBanner.setOpaque(false);
            estadoBanner.setBackground(mainBackgroundColor);
            estadoBanner.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(estadoBanner);
        }

        // Chat Banner
        {
            chatBanner = new JLabel(" ", SwingConstants.LEFT);
            chatBanner.setBounds((WINDOW_WIDTH -  (WINDOW_WIDTH/4)) - 150, 200, 300, 375);
            chatBanner.setOpaque(true);
            chatBanner.setBackground(mainBackgroundColor.brighter());
            chatBanner.setFont(new Font("Serif", Font.ITALIC, 11));
            container.add(chatBanner);
        }

        // Texto Chat
        {
            chatText = new FedeJTextField((WINDOW_WIDTH -  (WINDOW_WIDTH/4)) - 150, 585, 200, 40, "Ingresar mensaje");
            container.add(chatText);
        }

        // Boton Enviar Mensaje
        {
            enviarMensajeBoton = new JGradientButton(mainColor, secondary);
            enviarMensajeBoton.setBounds((WINDOW_WIDTH -  (WINDOW_WIDTH/4)) + 50, 585, 100, 40);
            enviarMensajeBoton.setText("Enviar");
            enviarMensajeBoton.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(enviarMensajeBoton);

            enviarMensajeBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    ViajeDTO viaje = (ViajeDTO) viajes.getSelectedItem();
                    ViajeController vc = new ViajeController();
                    vc.EnviarMensaje(UsuarioController.GetLoggedTurista(), viaje, chatText.getText());
                    chatText.reset();

                    // Update Chat
                    {
                        ArrayList<MensajeDTO> mensajesDtos = vc.GetChatDe(viaje);

                        // Set Mensajes
                        {
                            String chatString = "<html>";
                            for (MensajeDTO mensaje : mensajesDtos) {
                                chatString += (mensaje.GetEmisor() + " : " + mensaje.GetTexto() + "<br/>");
                            }
                            chatString += "</html>";
                            chatBanner.setText(chatString);
                        }
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
            components.add(ubicacionBanner);
            components.add(precioBanner);
            components.add(idiomaBanner);
            components.add(estadoBanner);
            components.add(guiaBanner);
            components.add(chatBanner);
            components.add(chatText);
            components.add(enviarMensajeBoton);
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
