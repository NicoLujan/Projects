
interface Queue {
	
	public Object get();
	
	public void set(Object o);
	
	public int getCantElementos();
	
	public QueueFifo getMaxFifo();
	
	public int getCantQueueFifo();
	
}
