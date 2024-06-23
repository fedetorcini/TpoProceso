package src.UsuarioPackage.TrofeoPackage.ControllerPackage;

import src.UsuarioPackage.TrofeoPackage.Trofeo;
import src.UsuarioPackage.TrofeoPackage.TrofeoReseña;

public class TrofeoDTO {
	
	private String descripcion;
	private int trofeoId;

	public TrofeoDTO(Trofeo trofeo) {
		this.descripcion = trofeo.toString();
		this.trofeoId = trofeo.GetId();
	}

	public int GetID() {
		return 0;
	}

}
