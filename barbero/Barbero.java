package barbero;

public class Barbero implements Runnable {

	Barberia barberia;

	public Barbero(Barberia b) {
		this.barberia = b;		
	}

	@Override
	public void run() {

		Cliente proximo;
		while (true) {
			proximo = llamarProximo();
			cortarPelo(proximo);
		}
	}
	
	/**El método retorna con un cliente distinto de nulo, es decir,
	 * tan pronto como cuando haya un cliente para atender*/
	private synchronized Cliente llamarProximo() {
		Cliente next = barberia.proximoCliente(); ///

		while (next == null) {			
			System.out.println("Barbero duerme porque no hay clientes");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			next = barberia.proximoCliente();
		}
		System.out.println("Barbero empieza a atender cliente " + next.name);
		return next;
	}

	private void cortarPelo(Cliente c) {
		try {
			// simulo que el corte de pelo toma un tiempo
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.terminoCorteDePelo();
		System.out.println("Barbero termina de atender a cliente " + c.name);
	}

	

	public synchronized void despertar() {		
		System.out.println("Barbero se despierta porque llegó cliente");
		this.notify();
	}

}

