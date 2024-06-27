package src.PagoPackage;

import java.util.Date;

public class PagoDTO {
    private int id;
    private int turistaId;
    private double monto;
    private Date fecha;
    private int guiaId;
    public PagoDTO (Pago pago) {
        this.id = pago.getId();
        this.turistaId = pago.getTuristaId();
        this.monto = pago.GetMonto();
        this.fecha = pago.getFecha();
        this.guiaId = pago.getGuiaId();
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return  " - $" + getMonto() + fecha;
    }
}
