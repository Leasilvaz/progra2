package Implementaciones;

import api.PilaTDA;

public class PilaTIFINAL implements PilaTDA {
	int a[];
	int cant;
	public void InicializarPila() {
		cant = 0;
		a = new int[100];
	}

	public void Apilar(int x) {
		for (int i = cant; i > 0; i--)
			a[i] = a[i-1];
		a[0] = x;
		cant ++;

	}

	public void Desapilar() {
		for (int i = 0; i < cant; i++)
			a[i] = a[i+1];
		cant++;
	}

	
	public int tope() {
		return a[0];
	}

	
	public boolean PilaVacia() {
		return cant == 0;
	}

}
