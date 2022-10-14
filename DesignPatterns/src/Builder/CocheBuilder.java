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
