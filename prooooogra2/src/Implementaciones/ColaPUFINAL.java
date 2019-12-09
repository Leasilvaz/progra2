package Implementaciones;

import api.ColaTDA;

public class ColaPUFINAL implements ColaTDA {
	int a[];
	int indice;
	
	public void InicializarCola() {
		indice = 0;
		a = new int[100];
	}

	public void Acolar(int x) {
		for(int i = indice; i > 0; i--)
			a[i] = a[i-1];
		a[0] = x;
		indice ++;
	}

	public void desacolar() {
		indice --;
	}

	public int Primero() {
		return a[indice - 1];
	}

	
	public boolean ColaVacia() {
		return indice == 0;
	}

}
