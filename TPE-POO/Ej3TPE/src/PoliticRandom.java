import java.util.List;

public class PoliticRandom extends Politic {

	public Queue getQueue(List<Object> q) {
		return ((Queue)(q.get((int)Math.random() * q.size() - 1)));
	}
}
