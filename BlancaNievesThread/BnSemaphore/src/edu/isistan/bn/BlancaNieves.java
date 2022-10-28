package edu.isistan.bn;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BlancaNieves implements Runnable {
	private List<Enano> esperando = new LinkedList<>();
	private Semaphore mutex = new Semaphore(1);
	private Semaphore cantEsperando = new Semaphore(0);

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

	private  Enano esperarEnano() {
		try {
		this.cantEsperando.acquire();
		this.mutex.acquire();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Enano e = this.esperando.remove(0);
		this.mutex.release();
		return e;
	}

	public void notificarEsperando(Enano e) {
		try {
			this.mutex.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.esperando.add(e);
		this.mutex.release();
		this.cantEsperando.release();
	}

}
