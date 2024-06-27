package src.ViajePackage.ServicioPackage;

public class Servicio {

	private String tipo;
	private double costo;

	public Servicio(ServicioDTO servicioDTO) {
		this.tipo = servicioDTO.getTipo();
		this.costo = servicioDTO.getCosto();
	}

	public String getTipo() { return tipo; }

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCosto() { return costo; }

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Servicio(String tipo, double costo) {
		this.tipo = tipo;
		this.costo = costo;
	}

	public ServicioDTO ToDto()
	{
		return new ServicioDTO(tipo, costo);
	}

}
