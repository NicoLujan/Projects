/*
 * El patr�n de dise�o prototipo tiene como finalidad crear nuevos objetos clonando una instancia creada 
 * previamente. Este patr�n especifica la clase de objetos a crear mediante la clonaci�n de un prototipo 
 * que es una instancia ya creada. La clase de los objetos que servir�n de prototipo deber� incluir en su 
 * interfaz la manera de solicitar una copia, que ser� desarrollada luego por las clases concretas de 
 * prototipos.
 */

package Prototype;

public class Coche {
	private String marca;
	private String modelo;
	private int puertas;
	
	public Coche() {}
	
	public Coche clonar() {
		Coche clon = new Coche();
		
		clon.marca = marca;
		clon.modelo = modelo;
		clon.puertas = puertas;
		
		return clon;
	}

}
