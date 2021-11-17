import java.util.*;

public abstract class AbstractMultiQueue implements Queue{
	List<Object> elementos;
	
	protected abstract Queue getQueue(List<Object> c);
	
	public AbstractMultiQueue() {
		elementos = new ArrayList<Object>();
	}
	
	public void set(Object o) {
		Queue cola = getQueue(elementos);
		cola.set(o);
	}
	
	public Object get() {
		Queue cola = getQueue(elementos);
		return cola.get();
	}
	
	public int getCantElementos() {
		int contador = 0;
		for(Object e:elementos) {
			contador += ((Queue)e).getCantElementos();
		}
		return contador;
	}
	
	public QueueFifo getMaxFifo() {
		QueueFifo max = new QueueFifo();
		for(Object q:elementos) {
			QueueFifo terminal = ((Queue)q).getMaxFifo();
			if(max.getCantElementos() < terminal.getCantElementos()) {
				max = terminal;
			}
		}
		return max;
	}
	
	public int getCantQueueFifo() {
		int contador = 0;
		for(Object q:elementos) {
			contador += ((Queue)q).getCantQueueFifo();
		}
		return contador;
	}
	
	public void agregarCola(Queue cola){
		elementos.add(cola);
	}
}
