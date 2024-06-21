package src.UsuarioPackage;

import java.util.HashMap;

public class Guia extends Usuario{

private static HashMap<Integer, Guia> guias = new HashMap<Integer, Guia>();
private String pais;
private String ciudad;

private String GetPais() {
	return pais;
}

private void SetPais(String pais) {
	this.pais = pais;
}

public String GetCiudad() {
	return ciudad;
}

private void SetCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public void EnviarMensaje(String mensaje)
{}

public static Guia RegistrarGuia(String pais, String ciudad) {
	Guia miGuia = new Guia();
	miGuia.SetPais(pais);
	miGuia.SetCiudad(ciudad);
	miGuia.SetId(IDs);
	IDs ++;
	
	guias.put(miGuia.GetId(), miGuia);
	
	System.out.println("Guia " + miGuia.GetCiudad() + " | " + miGuia.GetPais() + " fue creado exitosamente");
	return miGuia;
}

@Override
public String toString()
{
	return GetCiudad() + GetPais();
}

}
