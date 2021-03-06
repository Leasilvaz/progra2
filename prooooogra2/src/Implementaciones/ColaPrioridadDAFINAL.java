package Implementaciones;

import api.ColaPrioridadTDA;

public class ColaPrioridadDAFINAL implements ColaPrioridadTDA {
	int elementos[];
	int prioridades[];
	int indice;

	
	public void InicializarCola() {
		elementos = new int[100];
		prioridades = new int[100];
		indice = 0;
	}

	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice ;
		for (; j >= 0 && prioridades[j - 1] >= prioridad; j--){
			prioridades[j] = prioridades[j-1];
			elementos[j] = elementos[j-1];
		}
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice ++;
	}

	public void Desacolar() {
		indice --;
	}

	public int Primero() {
		return elementos[indice - 1];
	}

	public boolean ColaVacia() {
		return indice == 0;
	}

	
	public int Prioridad() {
		return prioridades[indice -1];
	}

}
