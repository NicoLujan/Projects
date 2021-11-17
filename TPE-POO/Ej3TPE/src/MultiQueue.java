import java.util.ArrayList;
import java.util.List;
public class MultiQueue implements Queue{
	
	private List<Object> elementos;
	private Politic politica;
	
	public MultiQueue(Politic p){
		elementos = new ArrayList<Object>();
		politica = p;
	}
	
	public void agregarCola(Queue cola){
		elementos.add(cola);
	}
	
	public Object get() {
		Queue cola = politica.getQueue(elementos);
		return cola.get();
	}
	
	public void set(Object o) {
		Queue cola = politica.getQueue(elementos);
		cola.set(o);
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

	public void setPolitica(Politic politica) {
		this.politica = politica;
	}
	
}
