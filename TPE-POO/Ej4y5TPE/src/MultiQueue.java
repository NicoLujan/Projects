import java.util.*;;

public class MultiQueue implements Queue{
	
	protected List<Queue> elementos;
	private Politic politicaExtraer;
	private Politic politicaColocar;
	
	public MultiQueue(Politic politicaExtraer,Politic politicaColocar){
		elementos = new ArrayList<Queue>();
		this.politicaColocar = politicaColocar;
		this.politicaExtraer = politicaExtraer;
	}
	
	public void setPoliticaExtraer(Politic politicaExtraer) {
		this.politicaExtraer = politicaExtraer;
	}

	public void setPoliticaColocar(Politic politicaColocar) {
		this.politicaColocar = politicaColocar;
	}
	
	public void agregarCola(Queue cola){
		elementos.add(cola);
	}
	
	public Object get() {
		Queue cola = politicaExtraer.getQueue(elementos);
		return cola.get();
	}
	
	public void set(Object o) {
		Queue cola = politicaColocar.getQueue(elementos);
		cola.set(o);
	}
	
	public int getCantElementos() {
		int contador = 0;
		for(Object e:elementos) {
			contador += ((Queue)e).getCantElementos();
		}
		return contador;
	}
	
	public int getCantQueueFifo() {
		int contador = 0;
		for(Object q:elementos) {
			contador += ((Queue)q).getCantQueueFifo();
		}
		return contador;
	}
	
}
