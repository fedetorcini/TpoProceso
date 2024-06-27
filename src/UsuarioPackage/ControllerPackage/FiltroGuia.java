package src.UsuarioPackage.ControllerPackage;

import java.util.ArrayList;

import src.ViajePackage.ServicioPackage.ServicioDTO;

public class FiltroGuia {

	protected int id;
	protected String nombre;
	protected String apellido;
	private String pais;
	private String ciudad;
	private float calificacion;
	private ArrayList<ServicioDTO> servicios;
	private ArrayList<String> idiomas;

	public FiltroGuia (){
		id = -1;
		nombre = null;
		apellido = null;
		pais = null;
		ciudad = null;
		calificacion = -1;
		servicios = null;
		idiomas = null;
	}

	public boolean Validar(GuiaDTO guia) {

		boolean valido = true;

		if (nombre != null)
		{
			if(!(guia.GetNombre() == nombre))
				valido = false;
		}
		if (apellido != null)
		{
			if (!(guia.GetApellido() == apellido))
				valido = false;
		}
		if (pais != null)
		{
			if (!(guia.getPais() == pais))
				valido = false;
		}
		if (ciudad != null)
		{
			if(!(guia.getCiudad() == ciudad))
				valido = false;
		}
		if (id != -1)
		{
			if(guia.GetId() != id)
				valido = false;
		}
		if (calificacion != -1)
		{
			if(!(guia.getCalificacion() >= calificacion))
				valido = false;
		}
		if (servicios != null)
		{
			for (ServicioDTO servicioFiltro : servicios)
			{
				boolean encontrado = false;
				for (ServicioDTO servicioGuia : guia.getServicios())
				{
					if (servicioGuia.getTipo() == servicioFiltro.getTipo())
					{
						encontrado = true;
					}
				}
				if (!encontrado)
				{
					valido = false;
				}
			}
		}
		if (idiomas != null)
		{
			for (String idiomaFiltro : idiomas)
			{
				boolean encontrado = false;
				for (String idiomaGuia : guia.getIdiomas())
				{
					if (idiomaGuia == idiomaFiltro)
					{
						encontrado = true;
					}
				}
				if (!encontrado)
				{
					valido = false;
				}
			}
		}
		return valido;
	}

	public void SetNombre(String nombre) { this.nombre = nombre; }

	public void SetId(int id) { this.id = id; }
}
