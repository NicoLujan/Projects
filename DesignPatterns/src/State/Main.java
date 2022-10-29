package State;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono tel1 = new Telefono();
		
		System.out.println(tel1.getEstado().desbloquear());
		System.out.println(tel1.getEstado().abrirCamara());
		System.out.println(tel1.getEstado().hacerFoto());
		System.out.println(tel1.getEstado().hacerFoto());

	}

}
