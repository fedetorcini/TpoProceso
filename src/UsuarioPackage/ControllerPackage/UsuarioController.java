package src.UsuarioPackage.ControllerPackage;

import java.util.ArrayList;

import src.UsuarioPackage.Guia;

public class UsuarioController {

public ArrayList<GuiaDTO> GetGuia(FiltroGuia filter)
{
	if (filter != null)
	{		
		ArrayList<GuiaDTO> filtrado = new ArrayList<GuiaDTO>();
		for (GuiaDTO guia : Guia.GetGuiasDTO())
		{
			filter.Validar(guia);
			filtrado.add(guia);
		}
		return null;
	}
	else
	{		
		return Guia.GetGuiasDTO();
	}
}
	

}
