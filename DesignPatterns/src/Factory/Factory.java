package Factory;

public class Factory {
	Precio precio;
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
