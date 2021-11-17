import java.util.*;
public class PoliticMax implements Politic{
	
	public Queue getQueue(List<Queue> colas) {
		Queue maxCola = null;
		int max = -1;

		for (Queue cola : colas) {
			if ((cola).getCantElementos() > max) {
				max = (cola).getCantElementos();
				maxCola = cola;
			}
		}

		return maxCola;
	}
}
