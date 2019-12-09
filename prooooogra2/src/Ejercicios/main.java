package Ejercicios;
import api.ColaTDA;
import Implementaciones.ColaPUFINAL;

import javax.sound.midi.Synthesizer;
import javax.swing.SingleSelectionModel;

import Implementaciones.ColaPIFINAL;
public class main {

	public static void main(String[] args) {
		ColaTDA c1 = new ColaPUFINAL();
		ColaTDA c2 = new ColaPIFINAL();
		c1.InicializarCola();
		c2.InicializarCola();
		
		for (int i = 12; i<18000; i = i * 2)
			c1.Acolar(i);
		
		ColaACola(c1, c2);
		
		while (!c2.ColaVacia()){
			System.out.println(c2.Primero());
			c2.desacolar();
		}
		
		

	}
	
public static void ColaACola(ColaTDA origen, ColaTDA destino){
	while(!origen.ColaVacia()){
		destino.Acolar(origen.Primero());
		origen.desacolar();
	}
	
	
}

	
}
