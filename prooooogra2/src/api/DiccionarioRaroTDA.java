package api;

public interface DiccionarioRaroTDA {
	void InicializarDiccionario();
	// siempre que el diccionario este inicializado
	void Agregar(int clave, int valor);
	// siempre que el diccionario este inicializado
	void EliminarClave(int clave);
	// siempre que el diccionario este inicializado
	void EliminarValor(int clave, int valor);
	// siempre que el diccionario este inicializado
	boolean ExisteClave(int clave);
	// siempre que el diccionario este inicializado
	float Promedio(int clave);
	// siempre que el diccionario este inicializado
	boolean DicVacio();
	// siempre que el diccionario este inicializado
	ColaTDA Claves(DiccionarioRaroTDA a);
	
}

