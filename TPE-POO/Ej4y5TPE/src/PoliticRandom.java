import java.util.List;

public class PoliticRandom implements Politic{

	public Queue getQueue(List<Queue> q) {
		return ((Queue)(q.get((int)Math.random() * q.size() - 1)));
	}
	
}
