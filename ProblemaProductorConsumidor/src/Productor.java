
public class Productor implements Runnable{
	private int maxGenerated;
	private IBuffer<Integer> buffer;
	private long waitTime;
	
	public Productor(int maxGenerated, IBuffer<Integer> buffer,long waitTime) {
		this.maxGenerated = maxGenerated;
		this.waitTime = waitTime;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		for(int i=0;i<maxGenerated;i++) {
			System.out.println("Thread "+name+" produce " + i);
			this.buffer.put(i);
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
