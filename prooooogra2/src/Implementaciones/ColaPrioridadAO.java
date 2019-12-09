package Implementaciones;

import api.ColaPrioridadTDA;

public class ColaPrioridadAO implements ColaPrioridadTDA {
	
	class Elemento{
		int valor;
		int prioridad;
	}
	int indice;
	Elemento [] elementos;

	
	public void InicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
	}

	
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		for (; j > 0 && elementos[j-1].prioridad >= prioridad; j--){
			elementos[j] = elementos[j-1];
		}
		elementos[j] = new Elemento();
		elementos[j].valor = x;
		elementos[j].prioridad = prioridad;
		indice ++;
	}

	public void Desacolar() {
		elementos[indice - 1] = null;
		indice --;
	}

	
	public int Primero() {
		return (elementos[indice - 1].valor);
	}

	
	public boolean ColaVacia() {
		return indice == 0;
	}

	
	public int Prioridad() {
		return (elementos[indice - 1].prioridad);
	}

}
