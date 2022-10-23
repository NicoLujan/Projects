package Adapter;

public class Horno implements Enchufable{

	boolean encendido;
	@Override
	public void enciende() {
		// TODO Auto-generated method stub
		this.encendido = true;
		
	}

	@Override
	public void apaga() {
		// TODO Auto-generated method stub
		this.encendido = false;
		
	}

	@Override
	public boolean estaEncendido() {
		// TODO Auto-generated method stub
		return encendido;
	}

}
