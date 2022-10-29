package State;

public abstract class Estado {
	
	protected Telefono telefono;
	
	public Estado(Telefono telefono) {
		this.telefono = telefono;
	}
	
	abstract public String desbloquear();
	abstract public String abrirCamara();
	abstract public String hacerFoto();

}
