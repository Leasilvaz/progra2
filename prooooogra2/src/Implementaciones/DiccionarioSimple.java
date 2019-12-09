package Implementaciones;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	
	class Elemento{
		int valor;
		int clave;
	}
	Elemento[] elementos;
	int cant;


	public void InicializarDiccionario() {
		cant = 0;
		elementos = new Elemento[100];
	}
	
	
	private int Clave2Indice(int clave){
		int i = cant -1;
		while (i >= 0 && elementos[i].clave != clave )
			i--;
		return i;
	}

	
	public void Agregar(int clave, int valor) {
		int pos = Clave2Indice(clave);
		if (pos == -1){
			pos = cant;
			elementos[pos] = new Elemento();
			elementos[pos].clave = clave;
			cant ++;
		}
		elementos[pos].valor = valor;
	}

	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if (pos >= 0){
			elementos[pos] = elementos[cant -1];
			cant --;
		}
	}

	
	public int recuperar(int clave) {
		int pos = Clave2Indice(clave);
		return elementos[pos].valor;
	}

	
	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoTA();
		c.InicializarConjunto();
		int i;
		for (i = 0; i < cant; i++)
			c.Agregar(elementos[i].clave);
		return c;
	}
}
