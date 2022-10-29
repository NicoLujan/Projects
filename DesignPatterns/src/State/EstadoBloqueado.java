package State;

public class EstadoBloqueado extends Estado{

	public EstadoBloqueado(Telefono telefono) {
		super(telefono);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String desbloquear() {
		// TODO Auto-generated method stub
		telefono.cambiaEstado(new EstadoDesbloqueado(telefono));
		return "El telefono ha sido desbloqueado";
	}

	@Override
	public String abrirCamara() {
		// TODO Auto-generated method stub
		return "No es posible abrir la camara ya que el telefono esta bloqueado";
	}

	@Override
	public String hacerFoto() {
		// TODO Auto-generated method stub
		return "No es posible hacer la foto ya que el telefono esta bloqueado";
	}

}
