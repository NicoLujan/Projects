import java.util.ArrayList;
import java.util.List;

public class QueueFifo implements Queue{
	
	private List<Object> elementos;
	
	public QueueFifo() {
		elementos = new ArrayList<Object>();
	}
	
	public Object get() {
		if(elementos.size() != 0) {
			Object aux = elementos.get(0);
			elementos.remove(0);
			return aux;
		}else
			return null;
	}
	
	public void set(Object o) {
		elementos.add(o);
	}
	
	public int getCantElementos() {
		return elementos.size();
	}
	
	public int getCantQueueFifo() {
		return 1;
	}
}
