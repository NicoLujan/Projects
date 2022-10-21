package barbero.witherrors;

/**
 * Clase Cliente de barbería que intenta obtener un
 * lugar en la barbería para realizarse un corte.
 * Cuando logra obtener un lugar, espera ser atendido.
 * **/
public class Cliente extends Thread{
	
	String name;
	Barberia barberia;
	boolean peloCortado = false;
	
	
	public Cliente(String name, Barberia b){
		this.name = name;
		this.barberia = b;		
	}
	
	@Override
	public void run(){
		
		if ( barberia.hayAsientoLibre() ) {
			barberia.tomarAsiento(this);
			esperarCorteDePelo();
		}
		else
			System.out.println("Cliente "+name+ " no encontró lugar y se retiró de la barbería");
	}
	
	
	public synchronized void esperarCorteDePelo() {			
		while ( !peloCortado )
			try {
				this.wait();
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
		System.out.println("Cliente "+name+ " se va de la barbería con su pelo cortado");
	}
	
	
	public synchronized void terminoCorteDePelo() {	
		this.peloCortado = true;
		System.out.println("Cliente "+name+ " fue atendido");
		this.notifyAll();		
	}
	
}

