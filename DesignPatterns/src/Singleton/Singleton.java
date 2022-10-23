/*
 * En ingenier�a de software, singleton o instancia �nica es un patr�n de dise�o que permite restringir 
 * la creaci�n de objetos pertenecientes a una clase o el valor de un tipo a un �nico objeto.
 * Su intenci�n consiste en garantizar que una clase solo tenga una instancia y proporcionar un punto de 
 * acceso global a ella.
 * 
 */

package Singleton;

public class Singleton {
	private static Singleton singleton;
	int contador;
	
	// Para que el constructor no pueda ser invocado desde afuera se hace privado
	private Singleton() {} 
	
	// Metodo static para poder acceder al singleton desde el main y no crear otra
	// instancia
	public static Singleton getInstance() {
		if(singleton == null) {
			return new Singleton();
		}
		return singleton;
	}
	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	

}
