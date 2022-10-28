package edu.isistan.bn;

import java.util.concurrent.Semaphore;

public class Mesa {

	private Semaphore sillas;
	private BlancaNieves bn;
	
	public Mesa(int cantSillas, BlancaNieves bn) {
		super();
		this.sillas = new Semaphore(cantSillas);
		this.bn = bn;
	}
	
	public void sentarse(Enano e) {
		Utils.log("Intentando sentarse...");
		try {
			this.sillas.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Utils.log("Ocupando "+this.sillas.availablePermits()+" sillas vacias");
		this.bn.notificarEsperando(e);
	}
	
	public void liberarSilla() {
		this.sillas.release();
		Utils.log("Liberando "+this.sillas.availablePermits()+" sillas vacias");
	}
	
}
