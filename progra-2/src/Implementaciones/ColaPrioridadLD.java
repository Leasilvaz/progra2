package Implementaciones;

import api.ColaPrioridadTDA;

public class ColaPrioridadLD implements ColaPrioridadTDA {
	
	public class NodoPrioridad{
		int valor;
		int prioridad;
		NodoPrioridad sig;
	}
	NodoPrioridad mayorprioridad;
	
	public void InicializarCola() {
		mayorprioridad = null;
	}
	
	public void AcolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.valor = x;
		nuevo.prioridad = prioridad;
		//Si la cola esta vacia o si es mas prioritario
		if (mayorprioridad == null || prioridad > mayorprioridad.prioridad){
			nuevo.sig = mayorprioridad;
			mayorprioridad = nuevo;
		}
		else {
			NodoPrioridad aux = mayorprioridad;
			//mayor prioridad no es null(no esta vacia la cola)
			//o es de menor prioridad
			
			while (aux.sig != null && aux.sig.prioridad >= prioridad)
				aux = aux.sig;
			nuevo.sig = aux.sig;
			nuevo = aux;
		}
	}
	
	public void Desacolar() {
		mayorprioridad = mayorprioridad.sig;
	}

	
	public int Primero() {
		return mayorprioridad.valor;
	}

	
	public boolean ColaVacia() {
		return (mayorprioridad == null);
	}

	
	public int Prioridad() {
		return mayorprioridad.prioridad;
	}

}
