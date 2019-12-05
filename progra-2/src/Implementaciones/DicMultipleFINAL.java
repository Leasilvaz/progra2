package Implementaciones;

import api.ConjuntoTDA;
import api.DiccionarioMTDA;

public class DicMultipleFINAL implements DiccionarioMTDA {
	
	class NodoClave{
		int clave;
		NodoClave sigClave;
		NodoValores valores;
	}
	
	class NodoValores{
		int valor;
		NodoValores sigValor;
	}
	
	NodoClave origen;

	public void InicializarDiccionario() {
		origen = null;
	}

	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if(nc == null){
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		NodoValores aux = nc.valores;
		while(aux!= null && aux.valor != valor)
			aux = aux.sigValor;
		if(aux == null){
			NodoValores nv = new NodoValores();
			nv.valor = valor;
			nv.sigValor = nc.valores;
			nc.valores = nv;
		}
		
		
	}
	
	private NodoClave Clave2NodoClave (int clave){
		NodoClave aux = new NodoClave();
		aux = origen;
		while(aux != null && aux.clave != clave)
			aux = aux.sigClave;
		return aux;
	}
	
	private void EliminarValorEnNodo(NodoClave nodo, int valor){
		if (nodo.valores != null)
			if (nodo.valores.valor == valor)
				nodo.valores = nodo.valores.sigValor;
			else{
				NodoValores aux = nodo.valores;
				while(aux.sigValor != null && aux.sigValor.valor != valor)
					aux = aux.sigValor;
				if(aux.sigValor != null)
					aux.sigValor = aux.sigValor.sigValor;
			}
	}
	
	public void Eliminar(int clave) {
		if(clave == origen.clave)
			origen = origen.sigClave;
		else{
			NodoClave aux = origen;
			while(aux.sigClave != null && aux.sigClave.clave != clave)
				aux= aux.sigClave;
			if(aux.sigClave != null)
				aux.sigClave = aux.sigClave.sigClave;
		}
	}

	public void EliminarValor(int clave, int valor) {
		if (origen != null)
			if (origen.valores.valor == valor){
				EliminarValorEnNodo (origen, valor);
				if(origen.valores == null){
					origen = origen.sigClave;
				}
			}
			else {
				NodoClave aux = origen;
				while(aux.sigClave != null && aux.sigClave.clave != clave)
					aux = aux.sigClave;
				if(aux.sigClave != null){
					EliminarValorEnNodo(aux.sigClave, valor);
					if(aux.sigClave.valores == null)
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
	}

	public ConjuntoTDA Recuperar(int clave) {
		ConjuntoTDA c = new ConjuntoTAFINAL();
		c.InicializarConjunto();
		NodoClave aux = Clave2NodoClave(clave);
		if(aux != null){
			NodoValores nv = aux.valores;
			while(nv.sigValor != null){
				c.Agregar(nv.valor);
				nv = nv.sigValor;
			}
		}
		return c;
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoTAFINAL();
		c.InicializarConjunto();
		NodoClave aux = origen;
		while(aux != null){
			c.Agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}

}
