package edu.isistan.bn;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Enano implements Runnable {

	private Semaphore tieneComida = new Semaphore(0);
	private Mesa mesa;
	private String nombre;
	
	public Enano(Mesa mesa, String nombre) {
		super();
		this.mesa = mesa;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		while(true) {
			Utils.log("Trabajando..");
			try {
				Thread.sleep((long) (100 + ThreadLocalRandom.current().nextDouble()*5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.log("Tiene hambre");
			this.mesa.sentarse(this);
			Utils.log("Esperando comida...");
			this.esperarComida();
			Utils.log("Comiendo...");
			try {
				Thread.sleep((long) (200 + ThreadLocalRandom.current().nextDouble()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.mesa.liberarSilla();
		}
	}

	private void esperarComida() {
		try {
			this.tieneComida.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void servirComida() {
		this.tieneComida.release();
	}

	@Override
	public String toString() {
		return "Enano [nombre=" + nombre + "]";
	}

}
