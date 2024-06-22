package src.UsuarioPackage.ControllerPackage;

import java.util.ArrayList;

public class FiltroGuia {

protected String nombre;
protected String apellido;
private String pais;
private String ciudad;
private float calificacion;
private ArrayList<ServicioDTO> servicios;
private ArrayList<String> idiomas;

public void Validar(GuiaDTO guia) {
	
	boolean valido = true;
	
	if (nombre != null)
	{
		if(!(guia.getNombre() == nombre))
			valido = false;
	}
	if (apellido != null)
	{
		if (!(guia.getApellido() == apellido))
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
				if (servicioGuia.GetTipo() == servicioFiltro.GetTipo())
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
}

}
