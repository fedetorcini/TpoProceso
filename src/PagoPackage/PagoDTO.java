package src.PagoPackage;

import src.UsuarioPackage.ControllerPackage.GuiaDTO;
import src.UsuarioPackage.ControllerPackage.TuristaDTO;
import src.ViajePackage.Controller.ViajeDTO;

import java.util.Date;

public class PagoDTO {

    private String estado;
    private int id;
    private int turistaId;
    private double monto;
    private Date fecha;
    private int guiaId;
    private int viajeId;

    public PagoDTO(Pago pago) {
        this.id = pago.GetId();
        this.turistaId = pago.GetTuristaId();
        this.monto = pago.GetMonto();
        this.fecha = pago.GetFecha();
        this.guiaId = pago.GetGuiaId();
        this.viajeId = pago.GetViajeId();
        this.estado = pago.GetEstado();
    }

    public PagoDTO(double monto, ViajeDTO viajeDto) {
        this.monto = monto;
        this.turistaId = viajeDto.GetTuristaId();
        this.guiaId = viajeDto.GetGuiaId();
        this.viajeId = viajeDto.GetId();
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
    public String toString() { return  " Pago de : -$" + monto + " a GuiaId : " + guiaId; }

    public int getViajeId() { return viajeId;}
}
