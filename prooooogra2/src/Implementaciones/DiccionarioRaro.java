package Implementaciones;

import api.ColaTDA;
import api.DiccionarioRaroTDA;
import api.PilaTDA;

public class DiccionarioRaro implements DiccionarioRaroTDA {
	
	class NodoClave{
		int clave;
		NodoValor valores;
		NodoClave sigclave;
	}
	class NodoValor{
		int valor;
		NodoValor sigvalor;
	}
	NodoClave origen;
	
	public void InicializarDiccionario() {
		origen = null;
	}

	public void Agregar(int clave, int valor) {

		NodoClave nuevo = new NodoClave();
		nuevo.clave = clave;
		if(origen == null || clave > origen.clave){
			nuevo.sigclave = origen;
			origen = nuevo;
		}
		else{
			NodoClave aux = origen;
			while(aux.sigclave!= null && aux.sigclave.clave >= clave)
				aux = aux.sigclave;
			nuevo.sigclave = aux.sigclave;
		}
		NodoValor aux = origen.valores;
		while (aux != null && aux.valor != valor)
			aux = aux.sigvalor;
		if(aux == null){
			NodoValor nv = new NodoValor();
			nv.valor = valor;
			nv.sigvalor = origen.valores;
			origen.valores = nv;
		}
	}
	
	public void EliminarClave(int clave) {
		if ( origen!= null ) {
			if ( origen.clave == clave) {
				origen = origen.sigclave; }
			else {
				NodoClave aux = origen;
				while (aux .sigclave != null && aux.sigclave.clave!= clave){
					aux = aux.sigclave;
					}
				if ( aux.sigclave!= null ) {
					aux.sigclave= aux.sigclave. sigclave;
					}
				}
			}
		}

	public void EliminarValor(int clave, int valor) {

		if(origen !=null){
			if(origen.clave == clave)
				EliminarValorEnNodo (origen, valor);
				if (origen.valores == null)
					origen = origen.sigclave;
			else{
				NodoClave aux = origen;
				while(aux.sigclave != null && aux.sigclave.clave != clave)
					aux = aux.sigclave;
				if (aux.sigclave!= null){
					EliminarValorEnNodo(aux, valor);
					if(aux.sigclave.valores == null)
						aux.sigclave = aux.sigclave.sigclave;
				}
			}
		 }
		}
	
	private void EliminarValorEnNodo(NodoClave nodo, int valor){
		if (nodo.valores.valor == valor)
			nodo.valores = nodo.valores.sigvalor;
		else{
			NodoValor aux = nodo.valores;
			while(aux.sigvalor != null && aux.sigvalor.valor != valor)
				aux = aux.sigvalor;
			if (aux.sigvalor!=null)
				aux.sigvalor = aux.sigvalor.sigvalor;
			}
		}

	public boolean ExisteClave(int clave) {
		NodoClave aux = origen;
		while (aux!= null && aux.clave != clave)
			aux = aux.sigclave;
		return (aux != null);
	}
	
	private NodoClave Clave2NodoClave( int clave){
		NodoClave aux = origen;
		while (aux != null && aux.clave!= clave)
			aux = aux.sigclave;
		return aux;
	}

	public float Promedio(int clave) {
		int suma = 0; 
		int cant = 0;
		NodoClave aux = Clave2NodoClave(clave);
		NodoValor nv = aux.valores;
		while(nv.sigvalor!=null){
			suma = suma + nv.valor;
			cant ++;
		}
		return (suma / cant);
	}

	public boolean DicVacio() {
		return origen == null;
	}

	public ColaTDA Claves(DiccionarioRaroTDA a) {
		ColaTDA c = new ColaPi();
		PilaTDA p = new PilaTI();
		NodoClave aux = new NodoClave();
		c.InicializarCola();
		p.InicializarPila();
		while(aux != null){
			p.Apilar(aux.clave);
			aux = aux.sigclave;
		} 
		while(!p.PilaVacia()){
			c.Acolar(p.tope());
			p.Desapilar();
		}
		return c;
	}
}
