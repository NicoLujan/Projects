package edu.isistan.bn;

import java.util.LinkedList;
import java.util.List;

public class BlancaNieves implements Runnable {
	private List<Enano> esperando = new LinkedList<>();

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

	private synchronized Enano esperarEnano() {
		while(this.esperando.isEmpty()) {
			Utils.log("Paseando");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Enano e = this.esperando.remove(0);
		return e;
	}

	public synchronized void notificarEsperando(Enano e) {
		this.esperando.add(e);
		this.notify();
	}

}
