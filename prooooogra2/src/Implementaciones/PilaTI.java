package Implementaciones;

import api.PilaTDA;

public class PilaTI implements PilaTDA {
	
	int a[], indice;

	public void InicializarPila() {
		a = new int[100];
		indice = 0;
		
	}

	
	public void Apilar(int x) {
		int i;
		for (i = indice - 1; i >= 0; i-- ){
			a[i + 1] = a[i];
		}
		a[0] = x;
		indice ++;
	}

	
	public void Desapilar() {
		for( int i = 0; i < indice; i++ )
			a[i] = a[i + 1];
		indice --;
	}

	
	public int tope() {
		return a[0];
	}

	
	public boolean PilaVacia() {
		return (indice == 0);
	}

}
