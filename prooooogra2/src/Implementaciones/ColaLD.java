package Implementaciones;

import api.ColaTDA;
import Implementaciones.Nodo; 

public class ColaLD implements ColaTDA {
	
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
		if (ultimo != null)
			ultimo.sig = aux;
		ultimo = aux;
		if (primero == null)
			primero = ultimo;
	}

	
	public void desacolar() {
		primero = primero.sig;
		if (primero == null)
			ultimo  = null;
	}

	
	public int Primero() {
		return primero.info;
	}

	
	public boolean ColaVacia() {
		return (ultimo == null);
	}

}
