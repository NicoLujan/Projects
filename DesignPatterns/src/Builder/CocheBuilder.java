/*
 * Como patr�n de dise�o, el patr�n builder (Constructor) se usa para permitir la creaci�n de una variedad 
 * de objetos complejos desde un objeto fuente (Producto), el objeto fuente se compone de una variedad de 
 * partes que contribuyen individualmente a la creaci�n de cada objeto complejo a trav�s de un conjunto de 
 * llamadas secuenciales a una implementaci�n espec�fica que extienda la clase Abstract Builder. 
 * As�, cada implementaci�n existente de Abstract Builder construir� un objeto complejo Producto de una 
 * forma diferente deseada. El patr�n builder es creacional.
 * 
 */

package Builder;

public class CocheBuilder {
	Vehiculo vehiculo;
	
	public CocheBuilder(String marca) {
		vehiculo = new Vehiculo();
		vehiculo.setMarca(marca);
	}
	public CocheBuilder setPuertas(int puertas) {
		vehiculo.setPuertas(puertas);
		return this;
	}
	public CocheBuilder setMotor(String motor) {
		vehiculo.setMotor(motor);
		return this;
	}
	public CocheBuilder setTipo(String tipo) {
		vehiculo.setTipo(tipo);
		return this;
	}
	public Vehiculo build() {
		return this.vehiculo;
	}
}
