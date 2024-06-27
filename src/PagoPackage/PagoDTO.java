package src.PagoPackage;

import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;

import java.util.Date;

public class PagoDTO {

    private int id;
    private int turistaId;
    private double monto;
    private Date fecha;
    private int guiaId;

    public PagoDTO(Pago pago) {
        this.id = pago.getId();
        this.turistaId = pago.getTuristaId();
        this.monto = pago.GetMonto();
        this.fecha = pago.getFecha();
        this.guiaId = pago.getGuiaId();
    }

    public PagoDTO(double monto, TuristaDTO turista, GuiaDTO guia) {
        this.monto = monto;
        this.turistaId = turista.GetId();
        this.guiaId = guia.GetId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getGuiaId() {
        return guiaId;
    }

    public void setGuiaId(int guiaId) {
        this.guiaId = guiaId;
    }

    public int getTuristaId() {
        return turistaId;
    }

    public void setTuristaId(int turistaId) {
        this.turistaId = turistaId;
    }

    public double GetMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    @Override
    public String toString() { return  " Pago de : -$" + monto + " a GuiaId : " + guiaId; }
}
