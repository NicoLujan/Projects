
public class HolaMundoThreads implements Runnable{
	
	private int repeats;
	
	HolaMundoThreads (int _repeats){
		repeats = _repeats;
	}
	
	@Override
	public void run() {
		long threadName = Thread.currentThread().getId();
		for(int i=1;i<=repeats;i++) {
			System.out.println("Hola Threads! Soy el thread " +threadName+" ejecutando por "+i+ " vez.");
		};
		
	}
	
}
