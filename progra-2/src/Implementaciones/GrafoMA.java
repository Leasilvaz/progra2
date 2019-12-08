package Implementaciones;

import api.ConjuntoTDA;
import api.GrafoTDA;


import Implementaciones.ConjuntoTAFINAL;

public class GrafoMA implements GrafoTDA {
	static int n = 100;
	int [] etiq;
	int [][] mady;
	int cantnod;
	
	public void InicializarGrafo() {
		mady = new int [n][n];
		etiq = new int [n];
		cantnod = 0;
	}

	public void AgregarVertice(int v) {
		etiq[cantnod] = v;
		for(int i = 0; i < cantnod; i++){
			mady[cantnod][i] = 0;
			mady[i][cantnod] = 0;
		}
		cantnod ++;
	}

	public void EliminarVertice(int v) {
		int ind = Vert2Indice(v);
		for (int i = 0; i < cantnod; i++)
			mady[i][ind] = mady[i][cantnod-1];
		for (int i = 0; i<cantnod; i++)
			mady[ind][i] = mady [cantnod-1][i];
		etiq[ind] = etiq[cantnod -1];
		cantnod --;
	}
	
	private int Vert2Indice(int v) {
		int k = cantnod - 1;
		while(k >= 0 && etiq[k] != v)
			k--;
		return k;
	}

	public ConjuntoTDA Vertices() {
		ConjuntoTDA c = new ConjuntoTAFINAL();
		c.InicializarConjunto();
		for(int i = 0; i< cantnod; i++)
			c.Agregar(etiq[i]);
		return c;
	}
	
	public void AgegarArista(int v1, int v2, int peso) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		mady[o][d] = peso;
	}

	public void EliminarArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		mady[o][d] = 0;
	}

	public boolean ExisteArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return mady[o][d]!= 0;
	}

	public int PesoArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return mady[o][d];
	}

}
