import java.util.List;

public class MultiQueueRandom extends AbstractMultiQueue {

	public MultiQueueRandom() {
		super();
	}
	@Override
	protected Queue getQueue(List<Object> c) {
		if(c.size() != 0) {
			return ((Queue)c.get((int)Math.random() * c.size()));
		}else
			return null;
	}

}
