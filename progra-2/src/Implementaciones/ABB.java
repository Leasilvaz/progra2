package Implementaciones;

import api.ABBTDA;

public class ABB implements ABBTDA {
	NodoABB raiz;
	
	public int Raiz() {
		return raiz.info;
	}
	
	public ABBTDA HijoIzq() {
		return raiz.hijoIzq;
	}

	public ABBTDA HijoDer() {
		return raiz.hijoDer;
	}
	
	public boolean ArbolVacio() {
		return (raiz  == null);
	}
	
	public void InicializarArbol() {
		raiz = null;
	}
	
	public void AgregarElem(int x) {
		if(raiz == null) {
			raiz = new NodoABB();
			raiz.info = x;
			raiz.hijoDer = new ABB();
			raiz.hijoDer.InicializarArbol();
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.InicializarArbol();
		}
		else if(raiz.info > x)
				raiz.hijoIzq.AgregarElem(x);
		else if(raiz.info < x)
			raiz.hijoDer.AgregarElem(x);
	}
	
	private int mayor(ABBTDA a) {
		if(a.HijoDer().ArbolVacio())
			return a.Raiz();
		else
			return mayor(a.HijoDer());
	}
	private int menor(ABBTDA a) {
		if(a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}

	public void EliminarElem(int x) {
		if(raiz != null) {
			if(raiz.info == x && raiz.hijoDer.ArbolVacio() && raiz.hijoIzq.ArbolVacio())
				raiz = null;
			else if (raiz.info == x && !raiz.hijoIzq.ArbolVacio()) {
				raiz.info = this.mayor(raiz.hijoIzq);
				raiz.hijoIzq.EliminarElem(raiz.info);
			}
			else if (raiz.info == x && raiz.hijoIzq.ArbolVacio()) {
				raiz.info = this.menor(raiz.hijoDer);
				raiz.hijoDer.AgregarElem(raiz.info);
			}
			else if(raiz.info < x)
				raiz.hijoDer.EliminarElem(x);
			else
				raiz.hijoIzq.EliminarElem(x);
		}
	}

}
