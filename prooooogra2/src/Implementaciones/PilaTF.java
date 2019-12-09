package Implementaciones;

/* TF = Tope al Final*/

import api.PilaTDA;

public class PilaTF implements PilaTDA {
	 int a [];
	 int indice;

	public void InicializarPila() {
		a = new int [100];
		indice = 0;

	}

	public void Apilar(int x) {
		a[indice] = x;
		indice ++;

	}

	public void Desapilar() {
		indice --;
	}

	public int tope() {
		return a[indice - 1];
	}

	public boolean PilaVacia() {
		return (indice == 0);
	}

}
