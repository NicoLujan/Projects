package Decorator;

public class TelefonoDecorator implements Telefono{
	
	private Telefono telefono;
	
	public TelefonoDecorator(Telefono telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public void crear() {
		// TODO Auto-generated method stub
		this.telefono.crear();		
	}

}