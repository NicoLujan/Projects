package edu.isistan.bn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {

	private int cantSillas;
	private int sillasOcupadas;
	private BlancaNieves bn;
	private Lock mutex;
	private Condition mesaLlena;
	
	public Mesa(int cantSillas, BlancaNieves bn) {
		super();
		this.cantSillas = cantSillas;
		this.bn = bn;
		this.sillasOcupadas = 0;
		this.mutex = new ReentrantLock();
		this.mesaLlena = this.mutex.newCondition();
	}
	
	public void sentarse(Enano e) {
		this.mutex.lock();
		Utils.log("Intentando sentarse...");
		while (this.cantSillas == this.sillasOcupadas) {
			try {
				Utils.log("Esperando silla");
				this.mesaLlena.await();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.sillasOcupadas++;
		Utils.log("Ocupando "+this.sillasOcupadas+"/"+this.cantSillas+" sillas");
		this.mutex.unlock();
		this.bn.notificarEsperando(e);
	}
	
	public void liberarSilla() {
		this.mutex.lock();
		this.sillasOcupadas--;
		Utils.log("Liberando "+this.sillasOcupadas+"/"+this.cantSillas+" sillas");
		this.mesaLlena.signal();
		this.mutex.unlock();
	}
	
}
