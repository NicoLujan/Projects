package Adapter;

public class Main {
	
	public static void enciende(Enchufable e) {
		e.enciende();
	}
	public static void apaga(Enchufable e) {
		e.apaga();
	}
	public static boolean estaEncendido(Enchufable e) {
		return e.estaEncendido();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horno miHorno = new Horno();
		Lampara miLampara = new Lampara();
		powerAdapter miLightBulb = new powerAdapter();
		
		enciende(miHorno);
		enciende(miLampara);
		enciende(miLightBulb);

	}

}
