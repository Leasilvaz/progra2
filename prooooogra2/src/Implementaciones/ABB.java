package Implementaciones;

import api.ABBTDA;
class NodoABB{
	int info;
	ABBTDA HijoIzq;
	ABBTDA HijoDer;
}


public class ABB implements ABBTDA {
	
	NodoABB raiz;
	
	public int Raiz() {
		return raiz.info;
	}


	public boolean ArbolVacio() {
		return raiz == null;
	}

	public void InicializarArbol() {
		raiz = null;
	}
	
	public ABBTDA HijoDer() {
		return raiz.HijoDer;
	}
	
	public ABBTDA HijoIzq() {
		return raiz.HijoIzq;
	}

	public void AgregarElem(int x) {
		if (raiz == null){
			raiz = new NodoABB();
			raiz.info = x;
			raiz.HijoIzq = new ABB();
			raiz.HijoIzq.InicializarArbol();
			raiz.HijoDer = new ABB();
			raiz.HijoDer.InicializarArbol();	
		}
		else if (raiz.info > x)
				raiz.HijoIzq.AgregarElem(x);
		else if (raiz.info < x)
				raiz.HijoDer.AgregarElem(x);
	}

	public void EliminarElem(int x) {
		if (raiz != null)
			if(raiz.info == x && raiz.HijoDer.ArbolVacio() && raiz.HijoIzq.ArbolVacio())
				raiz = null;
			else if (raiz.info == x && !raiz.HijoIzq.ArbolVacio()){
				raiz.info = this.mayor(raiz.HijoIzq);
				raiz.HijoIzq.EliminarElem(raiz.info);	
			}
			else if(raiz.info == x && raiz.HijoIzq.ArbolVacio()){
				raiz.info = this.menor(raiz.HijoDer);
				raiz.HijoDer.EliminarElem(raiz.info);
			}
			else if (raiz.info < x)
				raiz.HijoDer.EliminarElem(x);
				else
					raiz.HijoIzq.EliminarElem(x);
			}
				
	private int mayor(ABBTDA a){
		if(a.HijoDer().ArbolVacio())
			return a.Raiz();
		else 
			return mayor(a.HijoDer());
	}
	
	private int menor(ABBTDA a){
		if(a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else 
			return menor(a.HijoIzq());
	}
	
}
