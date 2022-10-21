package barbero.witherrors;

import java.util.LinkedList;
import java.util.Queue;

public class Barberia {

	int maxSillas;
	boolean barberoAtendiendo; 
	Barbero barbero;
	Queue<Cliente> clientesEsperando;
	
	/**
	 * Constructor de una Barbería con una
	 * cantidad de sillas disponibles
	 * **/
	public Barberia(int sillasSala){
		maxSillas = sillasSala;		
		clientesEsperando = new LinkedList<Cliente>();
		barbero = null;
		barberoAtendiendo = false;
	}
	
	public void setBarbero(Barbero b) {
		barbero = b;
	}
	
	/**
	 * Método que al ser invocado por un barbero
	 * le retorna el próximo cliente al que debe atender 
	 * */
	public synchronized Cliente proximoCliente(){
		Cliente next = clientesEsperando.poll();		
		barberoAtendiendo = next != null ? true : false;		
		System.out.println("["+Thread.currentThread().getName() + "] sillas ocupadas: "+ clientesEsperando.size() + "/" + maxSillas);
		return next;		
	}

	/**
	 * Método que invocado por un cliente para sentarse en una silla de
	 * la barbería. 
	 * **/
	public synchronized void tomarAsiento(Cliente c) {
		clientesEsperando.offer(c);
		System.out.println("Cliente "+c.name+ " espera en la barbería");
		System.out.println("["+Thread.currentThread().getName() + "]"+"sillas ocupadas: "+ clientesEsperando.size() + "/" + maxSillas);			
		if ( clientesEsperando.size() == 1 && !barberoAtendiendo )//despierto al barbero
			barbero.despertar();					
	}

	public synchronized boolean hayAsientoLibre() {		
		return clientesEsperando.size() < maxSillas;
	}
	
	
}
