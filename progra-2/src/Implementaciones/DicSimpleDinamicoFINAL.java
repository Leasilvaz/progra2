package Implementaciones;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import Implementaciones.NodoClaveValor;
import Implementaciones.ConjuntoTAFINAL;


public class DicSimpleDinamicoFINAL implements DiccionarioSimpleTDA {
	
	NodoClaveValor origen = new NodoClaveValor();
	

	public void InicializarDiccionario() {
		origen = null;
	}

	public void Agregar(int clave, int valor) {
		NodoClaveValor nc = IndiceNodoClave(clave);
		if (nc == null){
			nc = new NodoClaveValor();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		nc.valor = valor;
	}

	private NodoClaveValor IndiceNodoClave(int clave){
		NodoClaveValor aux = origen;
		while(aux!= null && aux.clave != clave)
			aux = aux.sigClave;
		return aux;
	}

	
	public void Eliminar(int clave) {
		if(origen != null)
			if(origen.clave == clave)
				origen = origen.sigClave;
			else{
				NodoClaveValor aux = origen;
				while(aux.sigClave != null && aux.sigClave.clave != clave)
					aux = aux.sigClave;
				if (aux.sigClave != null)
					aux.sigClave = aux.sigClave.sigClave;
			}
	}

	public int recuperar(int clave) {
		NodoClaveValor nc = IndiceNodoClave(clave);
		return nc.valor;
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA c1 = new ConjuntoTAFINAL();
		c1.InicializarConjunto();
		NodoClaveValor nc = origen;
		while(nc != null)
			c1.Agregar(nc.clave);
		return c1;
	}

}
