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
