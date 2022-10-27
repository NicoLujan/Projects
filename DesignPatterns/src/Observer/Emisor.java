package Observer;

import java.util.ArrayList;

public class Emisor {
	
	private ArrayList<Receptor> receptores = new ArrayList<Receptor>();
	
	public void meteReceptor(Receptor receptor) {
		this.receptores.add(receptor);
	}
	
	public void emite() {
		for(Receptor r : receptores) {
			r.recibe();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReceptorRadio r = new ReceptorRadio();
		ReceptorTV t = new ReceptorTV();
		ReceptorSatelite s = new ReceptorSatelite();
		
		Emisor e = new Emisor();
		e.meteReceptor(r);
		e.meteReceptor(s);
		e.meteReceptor(t);
		
		e.emite();

	}

}
