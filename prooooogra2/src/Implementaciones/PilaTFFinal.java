package Implementaciones;

import api.PilaTDA;

public class PilaTFFinal implements PilaTDA {
	int a[];
	int indice;
	
	public void InicializarPila() {
		a = new int[100];
		indice = 0;
	}

	
	public void Apilar(int x) {
		a[indice] = x;
		indice ++;
	}

	
	public void Desapilar() {
		indice--;
	}

	
	public int tope() {
		return a[indice -1];
	}

	
	public boolean PilaVacia() {
		return indice == 0;
	}

}
