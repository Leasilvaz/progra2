package Ejercicios;
import api.ColaTDA;
import api.ConjuntoTDA;
import api.ABBTDA;
import Implementaciones.ColaPUFINAL;
import Implementaciones.ABB;
import Implementaciones.ColaPIFINAL;
import Implementaciones.ConjuntoTAFINAL;
public class maain {

	public static void main(String[] args) {

		/*ColaTDA c1 = new ColaPUFINAL();
		ColaTDA c2 = new ColaPIFINAL();
		c1.InicializarCola();
		c2.InicializarCola();
		
		for (int i = 12; i<18000; i = i * 2)
			c1.Acolar(i);
		
		ColaACola(c1, c2);
		
		while (!c2.ColaVacia()){
			System.out.println(c2.Primero());
			c2.desacolar();
		}*/
		ABBTDA a1 = new ABB();
		a1.InicializarArbol();
		for(int i = 21; i<121213032; i = i *3 + 2){
			a1.AgregarElem(i);
			int j = i - 10;
			a1.AgregarElem(j);
		}
		System.out.println(Contar(a1));
		System.out.println(calcularProfundidad(a1, 67));
	}
	public static void ColaACola(ColaTDA origen, ColaTDA destino){
		while(!origen.ColaVacia()){
			destino.Acolar(origen.Primero());
			origen.desacolar();
		}
		
		
	}
	

	public static int Contar(ABBTDA a) {
		// Contar la cantidad de nodos de un ABB.
		if(a.ArbolVacio())
			return 0;
		else return(1 + Contar(a.HijoDer()) + Contar(a.HijoIzq()));

}
	public static void inOrder(ABBTDA a){
		if (!a.ArbolVacio()){
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
				}
		}
	
	public static int calcularProfundidad(ABBTDA t, int x) {
		//Dado un elemento y un ABB, calcular su profundidad en el  ́arbol. 􏰂
		if(t.ArbolVacio())
			return 0;
		else if(t.Raiz() == x)
			return 0;
		else if(t.Raiz() > x)
			return(1 + calcularProfundidad(t.HijoIzq(), x));
		else
			return(1 + calcularProfundidad(t.HijoDer(), x));
	}
	
	public static boolean existeElementoABB(ABBTDA t, int x) {
		//Dado un elemento determinar si esta o no en el arbol
		if(t.ArbolVacio())
			return false;
		else if(t.Raiz() > x){
			return existeElementoABB(t.HijoIzq(), x);
		}
		else if(t.Raiz()< x) {
			return existeElementoABB(t.HijoDer(), x);
		}
		else
			return true;		
	}
	public ConjuntoTDA nodosPares(ABBTDA a) {
		ConjuntoTDA cp = new ConjuntoTAFINAL();
		cp.InicializarConjunto();
		if(!a.ArbolVacio()) {
			if(a.Raiz() % 2 == 0)
				cp.Agregar(a.Raiz());
		}
		ConjuntoTDA ni = nodosPares(a.HijoIzq());
		ConjuntoTDA nd = nodosPares(a.HijoDer());
		while(!ni.ConjuntoVacio()) {
			int x = ni.Elegir();
			cp.Agregar(x);
			ni.Sacar(x);
		}
		while(!nd.ConjuntoVacio()) {
			int y = nd.Elegir();
			cp.Agregar(y);
			nd.Sacar(y);
		}
		return cp;
	}
		                                      

}
