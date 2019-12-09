package Implementaciones;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DicSimpleFINAL implements DiccionarioSimpleTDA {
	
	class Elemento{
		int clave;
		int valor;
	}
	Elemento elementos[];
	int cant;
	
	private int Clave2Indice(int clave){
		int i = cant -1;
		while(i >= 0 && elementos[i].clave != clave)
			i--;
		return i;
	}

	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cant = 0;
	}
	
	public void Agregar(int clave, int valor) {
		int pos = Clave2Indice(clave);
		if (pos < 0){
			elementos[pos] = new Elemento();
			elementos[pos].clave = clave;
			cant ++;
		}
		elementos[pos].valor = valor;
	}

	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if (pos >= 0){
			elementos[pos] = elementos[cant - 1];
			cant --;
		}
	}


	public int recuperar(int clave) {
		int pos = Clave2Indice(clave);
		return elementos[pos].valor;
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c1 = new ConjuntoTAFINAL();
		c1.InicializarConjunto();
		for (int i = 0; i < cant; i++)
			c1.Agregar(elementos[i].clave);
		return c1;
	}

}
