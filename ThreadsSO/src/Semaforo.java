
public class Semaforo {
	private int count = 0;
	
	public Semaforo(int initval) {
		count = initval;
	}
	
	public synchronized void down() {
		while (count <= 0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		count--;
	}
	
	public synchronized void up() {
		count++;
		notifyAll();
	}

}
