package Mediator;

public class ColegaConcreto2 extends Colega{
	
	@Override
	void recibe() {
		// TODO Auto-generated method stub
		System.out.println("He recibido un mensaje, soy ColegaConcreto2");
		
	}

	@Override
	void envia() {
		// TODO Auto-generated method stub
		System.out.println("He enviado un mensaje, soy ColegaConcreto2");
		mediator.reenvia(this);
		
	}

}
