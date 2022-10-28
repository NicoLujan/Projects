package edu.isistan.bn;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlancaNieves implements Runnable {
	private List<Enano> esperando = new LinkedList<>();
	private Lock mutex;
	private Condition bufferVacio;


	public BlancaNieves() {
		super();
		this.mutex = new ReentrantLock();
		this.bufferVacio = this.mutex.newCondition();
	}

	@Override
	public void run() {
		while(true) {
			Enano e = esperarEnano();
			Utils.log("Cocinando para: "+e);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Utils.log("Sirviendo: "+e);
			e.servirComida();
		}
	}

	private Enano esperarEnano() {
		this.mutex.lock();
		try {
			while(this.esperando.isEmpty()) {
				Utils.log("Paseando");
				try {
					this.bufferVacio.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return this.esperando.remove(0);
		} finally {
			this.mutex.unlock();
		}
	}

	public void notificarEsperando(Enano e) {
		this.mutex.lock();
		this.esperando.add(e);
		this.bufferVacio.signal();
		this.mutex.unlock();
	}

}
