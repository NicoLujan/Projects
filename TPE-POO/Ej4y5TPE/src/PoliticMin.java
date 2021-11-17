import java.util.*;;

public class PoliticMin implements Politic{

	public Queue getQueue(List<Queue> colas) {
		Queue minCola = null;
		int min = 9999999;

		for (Queue cola : colas) {
			if ((cola).getCantElementos() < min) {
				min = (cola).getCantElementos();
				minCola = cola;
			}
		}

		return minCola;
	}
}
