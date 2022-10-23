package Decorator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelefonoInteligente ti = new TelefonoInteligente(new TelefonoNextGen(new TelefonoBasico()));
		
		ti.crear();

	}

}
