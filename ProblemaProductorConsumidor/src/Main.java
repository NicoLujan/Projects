
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBuffer<Integer> buffer = new LocksBuffer<>(10);
		Productor productor = new Productor(100,buffer,1000);
		Consumidor consumidor = new Consumidor(buffer,1000);
		
		Thread tp = new Thread(productor);
		tp.setName("Productor");
		tp.start();
		
		Thread tc = new Thread(consumidor);
		tc.setName("Consumidor");
		tc.start();

	}

}
