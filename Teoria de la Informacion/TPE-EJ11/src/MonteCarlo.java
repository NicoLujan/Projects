import java.util.*;

public class MonteCarlo {

	private ArrayList emisiones;
	private ArrayList VectEst;
	private ArrayList VectEstAnt;
	private int cant_simb=0;
	
	public MonteCarlo(int n) {
		this.emisiones=new ArrayList();
		this.VectEst=new ArrayList();
		this.VectEstAnt=new ArrayList();
		VectEstAnt[0]=1.0f;
		
		for (int i=0;i<n;i++) {
			emisiones[i]=0;
			VectEst[i]=0;
			if(i!=0)
				VectEstAnt[i]=0.0f;
		}
	}
	
}
