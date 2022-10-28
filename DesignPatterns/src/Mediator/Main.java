package Mediator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mediator mediador = new MediadorConcreto();
		
		Colega colega1 = new ColegaConcreto();
		Colega colega2 = new ColegaConcreto1();
		Colega colega3 = new ColegaConcreto2();
		
		mediador.registra(colega1);
		mediador.registra(colega2);
		mediador.registra(colega3);
		
		colega1.envia();
		System.out.println("");
		colega3.envia();

	}

}
