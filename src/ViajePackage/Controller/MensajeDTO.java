package src.ViajePackage.Controller;

import src.NotificadorPackage.Mensaje;

public class MensajeDTO {

    private String texto;
    private String emisor;

    public MensajeDTO(Mensaje mensaje) {
        this.texto = mensaje.GetDescripcion();
        this.emisor = mensaje.GetEmisor().GetNombre() + " " + mensaje.GetEmisor().GetApellido();
    }

    public String GetEmisor() { return emisor;}

    public String GetTexto() { return texto;}
}
