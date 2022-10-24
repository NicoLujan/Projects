import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.*;

public class LocksBuffer<T> implements IBuffer<T>{
	
	private List<T> data;
	private int maxSize;
	private Lock lock;
	private Condition bufferLleno;
	private Condition bufferVacio;

	public LocksBuffer(int maxSize) {
		this.data = new LinkedList<T>();
		this.maxSize = maxSize;
		this.lock = new ReentrantLock();
		this.bufferVacio = this.lock.newCondition();
		this.bufferLleno = this.lock.newCondition();
	}
	
	@Override
	public void put(T value) {
		// TODO Auto-generated method stub
		this.lock.lock();
		while(this.data.size() >= maxSize) {
			try {
				bufferLleno.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.data.add(value);
		
		this.bufferVacio.signal();
		
		this.lock.unlock();
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		this.lock.lock();
		while(this.data.isEmpty()) {
			try {
				this.bufferVacio.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		T val= this.data.remove(0);
		
		this.bufferLleno.signal();
		
		this.lock.unlock();
		
		return val;
		
	}

}
