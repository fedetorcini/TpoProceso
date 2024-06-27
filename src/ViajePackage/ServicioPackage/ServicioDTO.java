package src.ViajePackage.ServicioPackage;

public class ServicioDTO {

public static final String TOUR_INDIVIDUAL = "TourIndividual";
public static final String TOUR_GRUPAL = "TourGrupal";
public static final String TRADUCCIONES = "Traducciones";

private String tipo;
private double costo;

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) { this.tipo = tipo; }

public double getCosto() { return costo; }

public void setCosto(double costo) {
	this.costo = costo;
}

public ServicioDTO(Servicio servicio) {
	this.costo = servicio.getCosto();
	this.tipo = servicio.getTipo();
}

public ServicioDTO(String tipo, double costo) {
	this.tipo = tipo;
	this.costo = costo;
}

public ServicioDTO ToDto(Servicio servicio)
{
	return new ServicioDTO(servicio);
}

}
