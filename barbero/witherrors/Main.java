package barbero.witherrors;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		final long MAX_SEC = 1000;
		
		Barberia sala = new Barberia(3);
		Barbero barbero = new Barbero(sala);
		sala.setBarbero(barbero);
		
		new Thread(barbero).start();		
		
		for (int i = 1; i <= 30; i++){
			//simulo una entrada de clientes espaciada en a
			//lo sumo 2 segundos entre uno y otro
			Thread.sleep((long)(MAX_SEC * Math.random()));
			new Cliente(String.valueOf(i),sala).start();
			
		}
	
	}

	
	
	
	
	
	
	

}
