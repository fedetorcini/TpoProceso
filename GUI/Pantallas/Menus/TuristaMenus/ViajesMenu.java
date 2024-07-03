package GUI.Pantallas.Menus.TuristaMenus;

import GUI.FedeJTextField;
import GUI.JGradientButton;
import GUI.Pantallas.Pantalla;
import src.PagoPackage.PagoDTO;
import src.UsuarioPackage.ControllerPackage.FiltroGuia;
import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.UsuarioPackage.ControllerPackage.UsuarioController;
import src.ViajePackage.Controller.MensajeDTO;
import src.ViajePackage.Controller.ViajeController;
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

    private JLabel guiaBanner;
    private JLabel ubicacionBanner;
    private JLabel precioBanner;
    private JLabel idiomaBanner;
    private JLabel estadoBanner;
    private JLabel abonadoBanner;

    private JGradientButton botonPagar;
    private JGradientButton botonReservar;
    private JGradientButton botonCompletar;
    private FedeJTextField pagoText;

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
                            abonadoBanner.setText("Abonado : $" + viaje.GetAbonado());

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

                        // Botonera
                        {
                            switch (viaje.GetEstado())
                            {
                                case "Pendiente":
                                    botonReservar.hide();
                                    botonCompletar.hide();
                                    botonPagar.show();
                                    pagoText.show();
                                    break;
                                case "Cancelado":
                                    botonReservar.hide();
                                    botonCompletar.hide();
                                    botonPagar.hide();
                                    pagoText.hide();
                                    break;
                                case "Finalizado":
                                    botonReservar.hide();
                                    botonCompletar.hide();
                                    botonPagar.hide();
                                    pagoText.hide();
                                    break;
                                case "Aceptado":
                                    botonReservar.show();
                                    botonCompletar.hide();
                                    botonPagar.show();
                                    pagoText.show();
                                    break;
                                case "Reservado":
                                    botonReservar.hide();
                                    botonCompletar.show();
                                    botonPagar.show();
                                    pagoText.show();
                                    break;
                                default:
                                    botonReservar.hide();
                                    botonCompletar.hide();
                                    botonPagar.hide();
                                    pagoText.hide();
                                    break;
                            }
                        }

                    }
                }
            });
        }

        // Guia Banner
        {
            guiaBanner = new JLabel(" ", SwingConstants.CENTER);
            guiaBanner.setBounds((WINDOW_WIDTH/4) - 100, 250, 200, 50);
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
            precioBanner.setBounds((WINDOW_WIDTH/4) - 100, 350, 200, 75);
            precioBanner.setOpaque(true);
            precioBanner.setBackground(mainBackgroundColor);
            precioBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(precioBanner);
        }

        // Idioma Banner
        {
            idiomaBanner = new JLabel(" ", SwingConstants.CENTER);
            idiomaBanner.setBounds((WINDOW_WIDTH/4) - 100, 300, 200, 75);
            idiomaBanner.setOpaque(false);
            idiomaBanner.setBackground(mainBackgroundColor);
            idiomaBanner.setFont(new Font("Serif", Font.BOLD, 40));
            container.add(idiomaBanner);
        }

        // Estado Banner
        {
            estadoBanner = new JLabel(" ", SwingConstants.CENTER);
            estadoBanner.setBounds((WINDOW_WIDTH/4) - 100, 450, 200, 50);
            estadoBanner.setOpaque(false);
            estadoBanner.setBackground(mainBackgroundColor);
            estadoBanner.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(estadoBanner);
        }

        // Abonado Banner
        {
            abonadoBanner = new JLabel(" ", SwingConstants.CENTER);
            abonadoBanner.setBounds((WINDOW_WIDTH/4) - 100, 500, 200, 50);
            abonadoBanner.setOpaque(false);
            abonadoBanner.setBackground(mainBackgroundColor);
            abonadoBanner.setFont(new Font("Serif", Font.BOLD, 18));
            container.add(abonadoBanner);
        }

        // Boton Pagar
        {
            botonPagar = new JGradientButton(mainColor, secondary);
            botonPagar.setBounds((WINDOW_WIDTH / 2) - 375, (WINDOW_HEIGHT / 2) + 200, 150, 50);
            botonPagar.setText(" Pagar ");
            botonPagar.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonPagar);

            botonPagar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ViajeController vc = new ViajeController();

                    double monto = Double.parseDouble(pagoText.getText());
                    ViajeDTO viajeDto = (ViajeDTO) viajes.getSelectedItem();

                    vc.Pagar(new PagoDTO(monto, viajeDto));
                    ArrayList<ViajeDTO> viajes = vc.GetViajesDeTurista(UsuarioController.GetLoggedTurista());
                    Actualizar(viajes);
                }
            });
        }

        // Texto Pago
        {
            pagoText = new FedeJTextField((WINDOW_WIDTH / 2) - 225, (WINDOW_HEIGHT / 2) + 200, 150, 50, "Ingresar monto");
            container.add(pagoText);
        }

        // Boton Reservar
        {
            botonReservar = new JGradientButton(mainColor, secondary);
            botonReservar.setBounds((WINDOW_WIDTH / 2) - 375, (WINDOW_HEIGHT / 2) + 250, 150, 50);
            botonReservar.setText(" Reservar ");
            botonReservar.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonReservar);

            botonReservar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ViajeDTO viajeDto = (ViajeDTO) viajes.getSelectedItem();

                    ViajeController vc = new ViajeController();
                    vc.Reservar(viajeDto);

                    ArrayList<ViajeDTO> viajesDto = vc.GetViajesDeTurista(UsuarioController.GetLoggedTurista());
                    Actualizar(viajesDto);
                }
            });
        }

        // Boton Completar
        {
            botonCompletar = new JGradientButton(mainColor, secondary);
            botonCompletar.setBounds((WINDOW_WIDTH / 2) - 375, (WINDOW_HEIGHT / 2) + 250, 150, 50);
            botonCompletar.setText(" Completar ");
            botonCompletar.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonCompletar);

            botonCompletar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ViajeDTO viajeDto = (ViajeDTO) viajes.getSelectedItem();

                    ViajeController vc = new ViajeController();
                    vc.Finalizar(viajeDto);

                    ArrayList<ViajeDTO> viajesDto = vc.GetViajesDeTurista(UsuarioController.GetLoggedTurista());
                    Actualizar(viajesDto);
                }
            });
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
            botonCrear = new JGradientButton(Color.BLUE.brighter(), Color.GRAY.brighter());
            botonCrear.setBounds((WINDOW_WIDTH / 2) + 75, (WINDOW_HEIGHT / 2) + 250, 300, 50);
            botonCrear.setText(" Nuevo Viaje ");
            botonCrear.setFont(new Font("Serif", Font.BOLD, 15));
            container.add(botonCrear);

            botonCrear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hide();
                    MainMenu mainMenu = (MainMenu) MainMenu.GetInstance();
                    NuevoViajeMenu nvm = (NuevoViajeMenu) NuevoViajeMenu.GetInstance();
                    mainMenu.AddSubpantalla(nvm);
                    nvm.Show();

                    ArrayList<GuiaDTO> guiasDtos = UsuarioController.GetGuia(new FiltroGuia());

                    nvm.Actualizar(guiasDtos);
                }
            });
        }

        // Componentes
        {
            components = new ArrayList<>();
            components.add(viajes);
            components.add(ubicacionBanner);
            components.add(botonCompletar);
            components.add(precioBanner);
            components.add(idiomaBanner);
            components.add(pagoText);
            components.add(estadoBanner);
            components.add(abonadoBanner);
            components.add(botonReservar);
            components.add(botonPagar);
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
        botonReservar.hide();
        botonCompletar.hide();
        botonPagar.hide();
        pagoText.hide();

        viajes.removeAllItems();

        for(ViajeDTO viajeDto : viajesDtos){
            viajes.addItem(viajeDto);
        }
    }
}
