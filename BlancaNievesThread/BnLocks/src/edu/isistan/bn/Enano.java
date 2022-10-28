package edu.isistan.bn;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Enano implements Runnable {

	private boolean tieneComida = false;
	private Mesa mesa;
	private String nombre;
	private Lock mutex;
	private Condition tieneComidaCond;
	
	public Enano(Mesa mesa, String nombre) {
		super();
		this.mesa = mesa;
		this.nombre = nombre;
		this.mutex = new ReentrantLock();
		this.tieneComidaCond = this.mutex.newCondition();
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
			this.tieneComida = false;
			this.mesa.liberarSilla();
		}
	}

	private void esperarComida() {
		this.mutex.lock();
		while(!this.tieneComida) {
			try {
				this.tieneComidaCond.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.mutex.unlock();
	}

	public void servirComida() {
		this.mutex.lock();
		this.tieneComida = true;
		this.tieneComidaCond.signal();
		this.mutex.unlock();
	}

	@Override
	public String toString() {
		return "Enano [nombre=" + nombre + "]";
	}

}
