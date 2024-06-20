package src.EstadosFactura;

import src.Factura;

public interface IEstadoFactura {

public abstract void Confirmar(Factura factura);
public abstract void MarcarPendiente(Factura factura);

}
