
public class Consumidor implements Runnable{
	private IBuffer<Integer> buffer;
	private long waitTime;
	
	public Consumidor(IBuffer<Integer> buffer,long waitTime) {
		this.waitTime = waitTime;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while(true) {
			Integer i = this.buffer.get();
			System.out.println("El thread "+name+" consume "+i);
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
