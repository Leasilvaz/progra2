	package Implementaciones;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DicSimpLD implements DiccionarioSimpleTDA {
	
	public class NodoClave{
		int valor;
		int clave;
		NodoClave sigclave;
	}
	NodoClave origen;
	
	public void InicializarDiccionario() {
		origen = null;
	}
	
	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2Nodo(clave);
		if (nc==null){
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigclave = origen;
			origen = nc;
		}
		nc.valor = valor;
	}
	
	private NodoClave Clave2Nodo(int clave){
		NodoClave aux = origen;
		while(aux != null && aux.clave != clave)
			aux = aux.sigclave;		
		return aux;
	}

	
	public void Eliminar(int clave) {
		if (origen != null)
			if (origen.clave == clave)
				origen = origen.sigclave;
			else{
				NodoClave aux = origen;
				while(aux.sigclave != null && aux.sigclave.clave != clave)
					aux = aux.sigclave;
				if (aux.sigclave != null)
					aux.sigclave = aux.sigclave.sigclave;
			}
	}

	public int recuperar(int clave) {
		NodoClave n = Clave2Nodo(clave);
		return n.valor;
	}

	
	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new CojuntoLD();
		c.InicializarConjunto();
		NodoClave aux = origen;
		while (aux != null){
			c.Agregar(aux.clave);
			aux = aux.sigclave;
		}
		return c;
	}

}
