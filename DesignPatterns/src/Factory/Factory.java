/*
 * En diseño de software, el patrón de diseño Factory Method consiste en utilizar una clase constructora 
 * (al estilo del Abstract Factory) abstracta con unos cuantos métodos definidos y 
 * otro(s) abstracto(s): el dedicado a la construcción de objetos de un subtipo de un tipo determinado. 
 * Es una simplificación del Abstract Factory, en la que la clase abstracta tiene métodos concretos que 
 * usan algunos de los abstractos; según usemos una u otra hija de esta clase abstracta, tendremos uno u 
 * otro comportamiento.
 */

package Factory;

public class Factory {
	Precio precio;
	
	@SuppressWarnings("unused")
	private Factory() {};
	
	public Factory(String pais) {
		if(pais.equalsIgnoreCase("España")) {
			System.out.println("España, precio en EUR");
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
