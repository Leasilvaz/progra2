package Implementaciones;


import api.ConjuntoTDA;
import api.DiccionarioMTDA;

public class DiccionarioMD implements DiccionarioMTDA {
	public class NodoClave{
		int clave;
		NodoValor Valores;
		NodoClave sigclave;
	}
	
	public class NodoValor{
		int valor;
		NodoValor sigvalor;
	}
	
	NodoClave origen;
	
	public void InicializarDiccionario() {
		origen = null;
	}
	
	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave (clave);
		if (nc == null){
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigclave = origen;
			origen = nc;
		}
		NodoValor aux = nc.Valores;
		while (aux != null && aux.valor != valor)
			aux = aux.sigvalor;
		if(aux == null){
			NodoValor nv = new NodoValor();
			nv.valor = valor;
			nv.sigvalor = nc.Valores;
			nc.Valores = nv;
		}

	}
	private NodoClave Clave2NodoClave( int clave){
		NodoClave aux = origen;
		while(aux != null && aux.clave != clave)
			aux = aux.sigclave;
		return aux;
	}

	
	public void Eliminar(int clave) {
		if (origen != null)
			if(origen.clave == clave)
				origen = origen.sigclave;
			else{
				NodoClave aux = origen;
				while(aux.sigclave != null && aux.sigclave.clave != clave)
					aux = aux.sigclave;
				if(aux.sigclave != null)
					aux.sigclave = aux.sigclave.sigclave;
			}
	}

	
	public void EliminarValor(int clave, int valor) {
		if(origen !=null){
			if(origen.clave == clave)
				EliminarValorEnNodo (origen, valor);
				if (origen.Valores == null)
					origen = origen.sigclave;
			else{
				NodoClave aux = origen;
				while(aux.sigclave != null && aux.sigclave.clave != clave)
					aux = aux.sigclave;
				if (aux.sigclave!= null){
					EliminarValorEnNodo(aux.sigclave, valor);
					if(aux.sigclave.Valores == null)
						aux.sigclave = aux.sigclave.sigclave;
				}
			}
		}
	}
	
	private void EliminarValorEnNodo(NodoClave nodo, int valor){
		if (nodo.Valores.valor == valor)
			nodo.Valores = nodo.Valores.sigvalor;
		else{
			NodoValor aux = nodo.Valores;
			while(aux.sigvalor != null && aux.sigvalor.valor != valor)
				aux = aux.sigvalor;
			if (aux.sigvalor!=null)
				aux.sigvalor = aux.sigvalor.sigvalor;
		}
	}

	
	public ConjuntoTDA Recuperar(int clave) {
		ConjuntoTDA cv = new ConjuntoTA();
		NodoClave aux = Clave2NodoClave(clave);
		cv.InicializarConjunto();
		if(aux != null){
			NodoValor nv = aux.Valores;
			while(nv != null){
			int x = nv.valor;
			cv.Agregar(x);
			nv = nv.sigvalor;
		}
		}
		return cv;
	}

	
	public ConjuntoTDA Claves() {
			ConjuntoTDA cc = new ConjuntoTA();
			cc.InicializarConjunto();
			NodoClave aux = origen;
			while(aux != null){
				cc.Agregar(aux.clave);
				aux = aux.sigclave;
			}
			return cc;
		}
	}

