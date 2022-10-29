package State;

public class Telefono {
	private Estado estado;
	
	public Telefono() {
		estado = new EstadoBloqueado(this);
	}
	
	public void cambiaEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
}
