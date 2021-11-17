import java.util.List;

public class MultiQueueInterspersed extends AbstractMultiQueue {
	
	private int intercalado;
	
	public MultiQueueInterspersed() {
		super();
		intercalado = 0;
	}
	
	
	@Override
	protected Queue getQueue(List<Object> c) {
		if(c.size() != 0) {
			if(intercalado == c.size()-1) {
				intercalado = 0;
				return ((Queue)c.get(c.size()-1));
			}else {
				intercalado++;
				return((Queue)c.get((c.size()) - 1));
			}
		}else
			return null;
	}

}
