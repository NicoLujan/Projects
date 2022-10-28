package edu.isistan.bn;


public class Mesa {

	private int cantSillas;
	private int sillasOcupadas;
	private BlancaNieves bn;
	
	public Mesa(int cantSillas, BlancaNieves bn) {
		super();
		this.cantSillas = cantSillas;
		this.bn = bn;
		this.sillasOcupadas = 0;
	}
	
	public synchronized void sentarse(Enano e) {
		Utils.log("Intentando sentarse...");
		while (this.cantSillas == this.sillasOcupadas) {
			try {
				Utils.log("Esperando silla");
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.sillasOcupadas++;
		Utils.log("Ocupando "+this.sillasOcupadas+"/"+this.cantSillas+" sillas");
		this.bn.notificarEsperando(e);
	}
	
	public synchronized void liberarSilla() {
		this.sillasOcupadas--;
		Utils.log("Liberando "+this.sillasOcupadas+"/"+this.cantSillas+" sillas");
		this.notify();
	}
	
}
