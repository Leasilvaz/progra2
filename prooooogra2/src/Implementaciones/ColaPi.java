package Implementaciones;

import api.ColaTDA;

public class ColaPi implements ColaTDA {
	 int [] a; 
	 int indice;

	public void InicializarCola() {
		a = new int[100];
		indice = 0;
	}

	public void Acolar(int x) {
		a[indice] = x;
		indice ++;
	}
	
	public void desacolar() {
		int i;
		for (i = 0; i < indice - 1; i++)
			a[i] = a[i+1];
		indice --;
	}

	
	public int Primero() {
		return a[0];
	}

	
	public boolean ColaVacia() {
		return indice == 0;
	}

}
