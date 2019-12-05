package Implementaciones;

import api.ConjuntoTDA;

public class CojuntoLD implements ConjuntoTDA {
	Nodo c;
	
	public void InicializarConjunto() {
	 c = null;
	}
	
	public boolean ConjuntoVacio() {
		return (c == null);
	}
	
	public void Agregar(int x) {
		if(!this.Pertenece(x)){
			Nodo aux = new Nodo();
			aux.info = x;
			aux.sig = c;
			c = aux;
		}	
	}
	
	public boolean Pertenece(int x){
		Nodo aux = c;
		while ((aux != null)&& (aux.info != x))
			aux = aux.sig;
		return (aux != null);
	}

	public int Elegir() {
		return c.info;
	}
	
	public void Sacar(int x) {
		if (c!=null)
			if (c.info == x){
				c = c.sig;
			}
			else{
				Nodo aux = c;
				while(aux != null && aux.info != x)
					aux = aux.sig;
				if(aux.sig != null){
					aux.sig = aux.sig.sig;
				}
			}
	}
}

















/*
 

public static ConjuntoTDA Interseccion(ConjuntoTDA conjunto1, ConjuntoTDA

conjunto2) {

ConjuntoTDA resultado = new ConjuntoLD();
ConjuntoTDA c1 = conjunto1.ObtenerCopia();

 while (!c1.ConjuntoVacio()) {
 int valor = c1.Elegir();
 if (conjunto2.Pertenece(valor)) {
 resultado.Agregar(valor);
 }
c1.Sacar(valor);
 }

 return resultado;
 }


-------UNION-------------------


public static ConjuntoTDA Union(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {

 ConjuntoTDA resultado = new ConjuntoLD();
 ConjuntoTDA c1 = conjunto1.ObtenerCopia();
 ConjuntoTDA c2 = conjunto2.ObtenerCopia();

 while (!c1.ConjuntoVacio()) {
 resultado.Agregar(c1.Elegir());
 c1.Sacar(c1.Elegir());
 }

 while (!c2.ConjuntoVacio()) {
 resultado.Agregar(c2.Elegir());
 c2.Sacar(c2.Elegir());
 }
 return resultado;
}


------Diferencia----

public static ConjuntoTDA Diferencia(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
 ConjuntoTDA c1 = conjunto1.ObtenerCopia();
 ConjuntoTDA c2 = conjunto2.ObtenerCopia();

 while (!c1.ConjuntoVacio()) {
 c2.Sacar(c1.Elegir());
 c1.Sacar(c1.Elegir());
 }

return c2;
}


-------------dif simetrica----

public static ConjuntoTDA DiferenciaSimetrica(ConjuntoTDA conjunto1, ConjuntoTDA

conjunto2) {

ConjuntoTDA union = new ConjuntoLD();
union = Union(conjunto1, conjunto2);
ConjuntoTDA interseccion = new ConjuntoLD();

interseccion = Interseccion(conjunto1, conjunto2);

 return Diferencia(interseccion, union);
 }
 
 
 ------son iguales----
 public static boolean SonIguales(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
boolean sonIguales = true;
ConjuntoTDA c1 = conjunto1.ObtenerCopia();
ConjuntoTDA c2 = conjunto1.ObtenerCopia();

while(!c1.ConjuntoVacio()) {
sonIguales = sonIguales && c2.Pertenece(c1.Elegir());
c1.Sacar(c1.Elegir());
}

c1 = conjunto1.ObtenerCopia();
c2 = conjunto1.ObtenerCopia();

 while(!c2.ConjuntoVacio()) {
sonIguales = sonIguales && c1.Pertenece(c2.Elegir());
c2.Sacar(c2.Elegir());
 }

 return sonIguales;
}






 */

