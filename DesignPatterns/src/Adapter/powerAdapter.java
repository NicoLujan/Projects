package Adapter;

public class powerAdapter implements Enchufable{

	public LightBulb lb = new LightBulb();
	@Override
	public void enciende() {
		// TODO Auto-generated method stub
		lb.turnOn(110);
		
	}

	@Override
	public void apaga() {
		// TODO Auto-generated method stub
		lb.turnOff();
		
	}

	@Override
	public boolean estaEncendido() {
		// TODO Auto-generated method stub
		return lb.isPoweredOn();
	}

}
