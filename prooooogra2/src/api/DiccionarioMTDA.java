package api;

public interface DiccionarioMTDA {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	void EliminarValor(int clave, int valor);
	ConjuntoTDA Recuperar(int clave);
	ConjuntoTDA Claves();
}
