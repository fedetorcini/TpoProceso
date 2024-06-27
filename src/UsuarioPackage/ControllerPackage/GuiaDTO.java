package src.UsuarioPackage.ControllerPackage;

import java.util.ArrayList;

import src.UsuarioPackage.Guia;
import src.ViajePackage.ServicioPackage.Servicio;
import src.ViajePackage.ServicioPackage.ServicioDTO;

public class GuiaDTO extends UsuarioDTO {

	public static String IDIOMA_HOLANDES = "Holandes";
	public static String IDIOMA_FRANCES = "Frances";
	public static String IDIOMA_CHINO = "Chino";
	public static String IDIOMA_ESPAÑOL = "Español";

	private String pais;
	private String ciudad;
	private float calificacion;
	private ArrayList<ServicioDTO> servicios;
	private ArrayList<String> idiomas;

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public ArrayList<ServicioDTO> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<ServicioDTO> servicios) {
		this.servicios = servicios;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public GuiaDTO(Guia guia) {
		super(guia);
		this.ciudad = guia.GetCiudad();
		this.pais = guia.GetPais();
		this.idiomas = guia.GetIdiomas();
		this.servicios = new ArrayList<>();
		this.calificacion = guia.GetPromedio();

		for (Servicio servicio : guia.GetServicios()){
			this.servicios.add(new ServicioDTO(servicio));
		}
	}

	public String GetLocacion() { return ciudad + ", " + pais; }

    public double GetCostoTotal() {
		double costo = 0;

		for (ServicioDTO servicio : servicios){
			costo += servicio.getCosto();
		}

		return costo;
    }
}
