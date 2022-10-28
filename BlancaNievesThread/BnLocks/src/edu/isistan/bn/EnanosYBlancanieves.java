package edu.isistan.bn;

public class EnanosYBlancanieves {

	public static void main(String[] args) {
		BlancaNieves bn = new BlancaNieves();
		Mesa m = new Mesa(4, bn);
		new Thread(bn, "Blancanieves").start();
		for(int i=0; i<7; i++) {
			Enano e = new Enano(m, "Enano "+i);
			new Thread(e, "Enano "+i).start();
		}
	}

}
