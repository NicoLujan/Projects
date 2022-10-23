/*
 * Como patrón de diseño, el patrón builder (Constructor) se usa para permitir la creación de una variedad 
 * de objetos complejos desde un objeto fuente (Producto), el objeto fuente se compone de una variedad de 
 * partes que contribuyen individualmente a la creación de cada objeto complejo a través de un conjunto de 
 * llamadas secuenciales a una implementación específica que extienda la clase Abstract Builder. 
 * Así, cada implementación existente de Abstract Builder construirá un objeto complejo Producto de una 
 * forma diferente deseada. El patrón builder es creacional.
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
