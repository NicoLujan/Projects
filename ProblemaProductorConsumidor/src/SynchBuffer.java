import java.util.LinkedList;
import java.util.List;

public class SynchBuffer<T> implements IBuffer<T>{
	
	private List<T> data;
	private int maxSize;

	public SynchBuffer(int maxSize) {
		this.data = new LinkedList<T>();
		this.maxSize = maxSize;
	}
	
	@Override
	public synchronized void put(T value) {
		// TODO Auto-generated method stub
		while(this.data.size() >= maxSize) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.data.add(value);
		this.notifyAll();
	}

	@Override
	public synchronized T get() {
		// TODO Auto-generated method stub
		while(this.data.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		T value = this.data.remove(0);
		
		this.notifyAll();
		
		return value;
		
	}

}
