package Adapter;

public class Lampara implements Enchufable{
	
	boolean encendido = false;
	@Override
	public void enciende() {
		// TODO Auto-generated method stub
		encendido = true;
		
	}

	@Override
	public void apaga() {
		// TODO Auto-generated method stub
		encendido = false;
		
	}

	@Override
	public boolean estaEncendido() {
		// TODO Auto-generated method stub
		return encendido;
	}

}
