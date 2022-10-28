package Mediator;

public class ColegaConcreto extends Colega{

	@Override
	void recibe() {
		// TODO Auto-generated method stub
		System.out.println("He recibido un mensaje, soy ColegaConcreto");
		
	}

	@Override
	void envia() {
		// TODO Auto-generated method stub
		System.out.println("He enviado un mensaje, soy ColegaConcreto");
		mediator.reenvia(this);
		
	}

}
