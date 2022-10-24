import java.util.LinkedList;
import java.util.List;

public class PrimerBuffer<T> implements IBuffer<T>{
	private List<T> data;
	private int maxSize;

	public PrimerBuffer(int maxSize) {
		this.data = new LinkedList<T>();
		this.maxSize = maxSize;
	}
	
	@Override
	public void put(T value) {
		// TODO Auto-generated method stub
		while(this.data.size() >= maxSize) {}
		
		this.data.add(value);		
	}

	@Override
	public T get() {
		// TODO Auto-generated method stub
		while(this.data.isEmpty()) {}
		
		return this.data.remove(0);
	}
}
