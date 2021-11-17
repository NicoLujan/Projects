
public class ParaProbar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueFifo cola1 = new QueueFifo();
		QueueFifo cola2 = new QueueFifo();
		QueueFifo cola3 = new QueueFifo();
		QueueFifo cola4 = new QueueFifo();
		QueueFifo cola5 = new QueueFifo();
		QueueFifo cola6 = new QueueFifo();
		
		MultiQueueRandom CM1 = new MultiQueueRandom();
		MultiQueueRandom CM3 = new MultiQueueRandom();
		MultiQueueRandom CM4 = new MultiQueueRandom();
		
		MultiQueueInterspersed CM2 = new MultiQueueInterspersed();
		
		cola1.set(1);
		cola1.set(2);
		
		cola2.set(3);
		cola2.set(4);
		
		cola4.set(5);
		cola4.set(6);
		
		cola5.set(7);
		
		cola6.set(8);
		cola6.set(9);
		cola6.set(10);
		
		CM3.agregarCola(cola1);
		CM3.agregarCola(cola2);
		
		CM2.agregarCola(CM3);
		CM2.agregarCola(cola3);
		CM2.agregarCola(cola4);
		
		CM4.agregarCola(cola5);
		CM4.agregarCola(cola6);
		
		CM1.agregarCola(CM2);
		CM1.agregarCola(CM4);
		
		CM1.set(12);
		CM1.set(11);
		
	}

}
