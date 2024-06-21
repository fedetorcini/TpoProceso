package src.FacturaPackage;

import java.util.Calendar;
import java.util.Date;

public class Pago {

private double monto;
private Date fecha;

public Pago(double nuevoMonto)
{
	monto = nuevoMonto;
	fecha = Calendar.getInstance().getTime();
}

void Pagar()
{
}

public double GetMonto() {
	return monto;
}

}
