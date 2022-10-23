/*
 * El patrón de diseño prototipo tiene como finalidad crear nuevos objetos clonando una instancia creada 
 * previamente. Este patrón especifica la clase de objetos a crear mediante la clonación de un prototipo 
 * que es una instancia ya creada. La clase de los objetos que servirán de prototipo deberá incluir en su 
 * interfaz la manera de solicitar una copia, que será desarrollada luego por las clases concretas de 
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
