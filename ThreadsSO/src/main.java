
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++) {
			Thread miThread = new Thread(new HolaMundoThreads(10000));
			miThread.setName("Thread "+i);
			miThread.start();
		}

	}

}
