package src.UsuarioPackage.TrofeoPackage;

import src.Observer.IObservador;
import src.Observer.Observable;

public abstract class Trofeo<T> extends Observable<String> implements IObservador<T>{

protected static int IDs = 0;
protected int trofeoId;

protected int GetTrofeoId() {
	return trofeoId;
}

protected void SetTrofeoId(int trofeoId) {
	this.trofeoId = trofeoId;
}


}
