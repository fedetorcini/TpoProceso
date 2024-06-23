package src.ViajePackage.ServicioPackage;

public class ServicioDTO {

private String tipo;
private double costo;

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public double getCosto() {
	return costo;
}

public void setCosto(double costo) {
	this.costo = costo;
}


public ServicioDTO(String tipo, double costo) {
	this.tipo = tipo;
	this.costo = costo;
}

public ServicioDTO ToDto()
{
	return new ServicioDTO(tipo, costo);
}

}
