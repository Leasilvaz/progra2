package Implementaciones;

import api.ColaTDA;

public class ColaPU implements ColaTDA {
	
	int [] a;
	int indice;
	
	public void InicializarCola() {
		 a = new int[100];
		 indice = 0;
	}

	
	public void Acolar(int x) {
		int i;
		for (i = indice - 1; i >= 0; i-- )
			a[i+1] = a[i];
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
		return (indice == 0);
	}

}
