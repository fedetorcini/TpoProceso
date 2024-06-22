package src.UsuarioPackage.TrofeoPackage;

import src.NotificadorPackage.Mensaje;
import src.ObserverPackage.IObservador;
import src.ObserverPackage.Observable;

public abstract class Trofeo<T> extends Observable<Mensaje> implements IObservador<T>{

protected static int IDs = 0;
protected int trofeoId;

protected int GetTrofeoId() {
	return trofeoId;
}

protected void SetTrofeoId(int trofeoId) {
	this.trofeoId = trofeoId;
}


}
