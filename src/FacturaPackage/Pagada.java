package src.FacturaPackage;

public class Pagada implements IEstadoFactura{

@Override
public void Confirmar(Factura factura) {
	System.out.println("La factura ya está paga");
}

}
