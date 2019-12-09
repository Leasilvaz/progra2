package Implementaciones;

import api.ColaTDA;
import Implementaciones.Nodo;

public class ColaLDFINAL implements ColaTDA {
	
	Nodo primero;
	Nodo ultimo;
	
	public void InicializarCola() {
		primero = null;
		ultimo = null;
	}

	public void Acolar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = null;
		// si la cola no estaba vacia
		if(ultimo != null)
			aux.sig = ultimo;
		ultimo = aux;
		//si la cola esta vacia
		if(primero == null)
			primero = ultimo;
	}

	public void desacolar() {
		primero = primero.sig;
		//si la cola queda vacia
		if(primero == null)
			ultimo = null;
	}

	public int Primero() {
		return primero.info;
	}

	public boolean ColaVacia() {
		return ultimo == null;
	}

}
