/*
 * En dise�o de software, el patr�n de dise�o Factory Method consiste en utilizar una clase constructora 
 * (al estilo del Abstract Factory) abstracta con unos cuantos m�todos definidos y 
 * otro(s) abstracto(s): el dedicado a la construcci�n de objetos de un subtipo de un tipo determinado. 
 * Es una simplificaci�n del Abstract Factory, en la que la clase abstracta tiene m�todos concretos que 
 * usan algunos de los abstractos; seg�n usemos una u otra hija de esta clase abstracta, tendremos uno u 
 * otro comportamiento.
 */

package Factory;

public class Factory {
	Precio precio;
	
	@SuppressWarnings("unused")
	private Factory() {};
	
	public Factory(String pais) {
		if(pais.equalsIgnoreCase("Espa�a")) {
			System.out.println("Espa�a, precio en EUR");
			precio = new EuroFactory();
		}else {
			System.out.println("Otro pais, precio en USD");
			precio = new DolarFactory();
		}
	}
	
	public double getPrecio() {
		return precio.getPrecio();
	}
}
