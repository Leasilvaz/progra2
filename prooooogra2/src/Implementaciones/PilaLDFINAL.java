package Implementaciones;

import api.PilaTDA;
import Implementaciones.Nodo;
public class PilaLDFINAL implements PilaTDA {
	Nodo primero;

	public void InicializarPila() {
		primero = null;
	}

	public void Apilar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = primero;
		primero = aux;
	}

	public void Desapilar() {
		primero = primero.sig;
	}

	public int tope() {
		return primero.info;
	}

	public boolean PilaVacia() {
		return primero == null;
	}

}
