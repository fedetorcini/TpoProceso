package src.PagoPackage;

import java.util.Date;

public class PagoDTO {
    private int id;
    private int turistaId;
    private double monto;
    private Date fecha;
    public PagoDTO (Pago pago) {
        this.id = pago.getId();
        this.turistaId = pago.getTuristaId();
        this.monto = pago.GetMonto();
        this.fecha = pago.getFecha();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
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
