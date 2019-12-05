package Implementaciones;

import api.ConjuntoTDA;
import api.DiccionarioMTDA;

public class DicMultipleAFINAL implements DiccionarioMTDA {
	
	class Elemento{
		int valores[];
		int clave;
		int cantValores;
	}
	Elemento elementos[];
	int cantClaves;

	public void InicializarDiccionario() {
		cantClaves = 0;
		elementos = new Elemento[100];

	}
	private int Indice2Clave(int clave){
		int pos = cantClaves - 1;
		while (pos >= 0 && elementos[pos].clave != clave)
			pos --;
		return pos;
	}
	private int Indice2Valor(Elemento e, int valor){
		int i = e.cantValores - 1;
		while(i >=0 && e.valores[i] != valor)
			i--;
		return i;
	}

	public void Agregar(int clave, int valor) {
		int posc = Indice2Clave(clave);
		if (posc == -1){
			posc = cantClaves;
			elementos[posc] = new Elemento();
			elementos[posc].clave = clave;
			elementos[posc].cantValores = 0;
			elementos[posc].valores = new int[100];
			cantClaves ++;
		}
		int posv = Indice2Valor(elementos[posc], valor);
		if (posv == -1){
			elementos[posc].valores[elementos[posc].cantValores] = valor;
			elementos[posc].cantValores ++;
		}
	}

	public void Eliminar(int clave) {
		int posc = Indice2Clave(clave);
		if(posc != -1){
			elementos[posc] = elementos[cantClaves - 1];
			cantClaves --;
		}
	}
	
	public void EliminarValor(int clave, int valor) {
		int posc = Indice2Clave(clave);
		if(posc != -1){
			int posv = Indice2Valor(elementos[posc], valor);
			if(posv != -1){
				elementos[posc].valores[posv] = elementos[posc].valores[elementos[posc].cantValores - 1];
				elementos[posc].cantValores --;
				if(elementos[posc].cantValores == 0)
					Eliminar(clave);
			}
		}
	}

	
	public ConjuntoTDA Recuperar(int clave) {
		ConjuntoTDA c = new ConjuntoTAFINAL();
		c.InicializarConjunto();
		int posc = Indice2Clave(clave);
		if(posc != -1){
			int i = elementos[posc].cantValores - 1;
			while( i <= 0){
				c.Agregar(elementos[posc].valores[i]);
				i--;
			}
		}
		return c;
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoTAFINAL();
		c.InicializarConjunto();
		for (int i = 0; i < cantClaves; i++)
			c.Agregar(elementos[i].clave);
		return c;
	}

}
