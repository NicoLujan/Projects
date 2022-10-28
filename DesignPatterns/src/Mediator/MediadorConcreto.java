package Mediator;

import java.util.ArrayList;

public class MediadorConcreto extends Mediator{

	ArrayList<Colega> colegas = new ArrayList<Colega>();
	
	@Override
	void registra(Colega colega) {
		// TODO Auto-generated method stub
		if(!colegas.contains(colega)) {
			colegas.add(colega);
			colega.setMediator(this);
		}
		
	}

	@Override
	void reenvia(Colega colega) {
		// TODO Auto-generated method stub
		for(Colega actual : colegas) {
			if(!actual.equals(colega)) {
				actual.recibe();
			}
		}
		
	}

}
