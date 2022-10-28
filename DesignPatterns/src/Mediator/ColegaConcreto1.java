package Mediator;

public class ColegaConcreto1 extends Colega{

	@Override
	void recibe() {
		// TODO Auto-generated method stub
		System.out.println("He recibido un mensaje, soy ColegaConcreto1");
		
	}

	@Override
	void envia() {
		// TODO Auto-generated method stub
		System.out.println("He enviado un mensaje, soy ColegaConcreto1");
		mediator.reenvia(this);
		
	}

}
