package Implementaciones;

import api.ConjuntoTDA;
import api.DiccionarioMTDA;

public class DiccionarioM implements DiccionarioMTDA {
	class Elemento{
		int cantValor;
		int [] valores;
		int clave;
	}
	Elemento[] elementos;
	int cantClaves;
	
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cantClaves = 0;
	}
	
	private int Clave2Indice(int clave){
		int i = cantClaves - 1;
		while (i >= 0 && elementos[i].clave != clave)
			i--;
		return i;
	}
	private int Valor2Indice(int posc, int valor){
		int i = elementos[posc].cantValor - 1;
		while(i >= 0 && elementos[posc].valores[i]!= valor)
			i--;
		return i;
	}
	
	public void Agregar(int clave, int valor) {
		int posc = Clave2Indice(clave);
		if (posc == -1){
			posc = cantClaves;
			elementos[posc] = new Elemento();	
			elementos[posc].clave = clave;
			elementos[posc].cantValor = 0;
			elementos[posc].valores = new int[100];
			cantClaves ++;
		}
		int posv = Valor2Indice(posc, valor);
		if(posv == -1){
			posv = elementos[posc].cantValor;
			elementos[posc].valores[posv] = valor;
			elementos[posc].cantValor ++;
	}
}

	public void Eliminar(int clave) {
		int posc = Clave2Indice(clave);
		if (posc != -1){
			elementos[posc] = elementos[cantClaves - 1];
			cantClaves --;
		}
	}
	
	public void EliminarValor(int clave, int valor) {
		int posc = Clave2Indice(clave);
		if (posc != -1){	
			int posv = Valor2Indice(posc, valor);
			if (posv != -1){
				elementos[posc].valores[posv] = elementos[posc].valores[elementos[posc].cantValor - 1];
				elementos[posc].cantValor --;
				if (elementos[posc].cantValor == 0)
					Eliminar(clave);
			}
		}
	}

	
	public ConjuntoTDA Recuperar(int clave) {
		ConjuntoTDA cv = new ConjuntoTA();
		cv.InicializarConjunto();
		int posc = Clave2Indice(clave);
		if (posc != -1){
			int i = 0;
			while (i < elementos[posc].cantValor)
				cv.Agregar(elementos[posc].valores[i]);
				i ++;
		}
		return cv;
	}

	
	public ConjuntoTDA Claves() {
		ConjuntoTDA cc = new ConjuntoTA();
		cc.InicializarConjunto();
		for (int i = 0; i<cantClaves; i ++)
			cc.Agregar(elementos[i].clave);
		return cc;
	}
}
