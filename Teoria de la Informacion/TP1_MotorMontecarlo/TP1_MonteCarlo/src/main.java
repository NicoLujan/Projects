//Ejercicio 9
/*
 * a) Epsilon = 0.05,0.000005,0.0000000005,0.00000000000005
 * 
 * A medida que la cota de error era mas "chica" el resultado obtenido por el algoritmo era
 * mas preciso aunque mas "lejano" e impreciso de lo que deb�a ser. 
 * 
 * 
 * 
 2.a) Se debe programar un metodo para la segunda extraccion que dependa de lo que haya salido
en la primera.
public static int sacarSegundoSobre(int S1){
	float [] matriz_acum={1/2,1},{3/4,1};
	float p = (float)Math.rand();
	for(int i=0;i<2;i++){
		if(p<matriz_acum[S1,i])
			return i;
	
	}
	return -1;
}

1.a)
public class main {
	
	static float epsilon = 0.000000000000000000005f;
	static int MIN = 1000;
	
	public static int sacarSobre() {
		float prob_acum[]= {0.6f,1};
		float sobre = (float)Math.random();
		
		for(int i=0;i<2;i++) {
			if(sobre<prob_acum[i])
				return i;
		}
		return -1;
	}
	
	public static boolean Converge(float prob_ant,float prob_act) {
		return (Math.abs(prob_ant - prob_act) < epsilon);
	}

	public static void main(String[] args) {
		
		float prob_act=0.0f,prob_ant=-1.0f,muestras=0.0f,exitos=0.0f;
		
		while ((!Converge(prob_ant,prob_act)) || (muestras < MIN)) {
			int S1=sacarSobre();
			int S2=sacarSobre();
			
			if((S1 == 0) || (S2 == 0)) // Para el 1.b se cambia el if por: if((S1==0 && S2==1) || (S1==1 && S2==0))
				exitos++;			   // Para el 1.c lo mismo que el 1.b pero: if(S2==0) 
			
			
			muestras++;
			prob_ant = prob_act;
			prob_act = exitos/muestras;
		}
		
		System.out.println(prob_act);
	}

}*/

public class main {
	
	static float epsilon = 0.0000000000000005f;
	static int MIN = 10000000;
	
	int [][] matriz = {{2,4,4},{6,6,9},{8,10,12}};
	
	//4.a
	static int SacarMuestra() {
		float [] EdoSdadoNeg= {0.00262f,1f}; // 0-> Persona enferma dado que salio negativo
		float p = (float)Math.random();
		
		for(int i=0;i<2;i++) {
			if(p<EdoSdadoNeg[i]) {
				return i;
			}
		}
		
		return -1;
	}
	
	//4.b
	static int SacarMuestra2() {
		float [] EdoSdadoPos = {0.893379f,1}; // 0 -> persona sana dado que salio positivo
		float p = (float)Math.random();
		
		for(int i=0;i<2;i++) {
			if(p<EdoSdadoPos[i])
				return i;
		}
		
		
		return -1;
	}
	
	
	public static boolean Converge(float prob_ant,float prob_act) {
		return (Math.abs(prob_ant - prob_act) < epsilon);
	}
	
	public static void main(String[] args) {
		float exitos=0.0f,muestras=0.0f,p_ant=-1.0f,p_act=0.0f;
		
		while(!Converge(p_ant,p_act) || muestras<MIN) {
			int estado = SacarMuestra();
			if(estado == 1)
				exitos++;
			
			muestras++;
			p_ant=p_act;
			p_act = exitos/muestras;
		}
		
		System.out.println(p_act);
	}
}
