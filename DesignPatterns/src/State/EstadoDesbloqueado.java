package State;

public class EstadoDesbloqueado extends Estado{
	
	public EstadoDesbloqueado(Telefono telefono) {
		super(telefono);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String desbloquear() {
		// TODO Auto-generated method stub
		return "El telefono ya estaba desbloqueado";
	}

	@Override
	public String abrirCamara() {
		// TODO Auto-generated method stub
		telefono.cambiaEstado(new EstadoCamaraAbierta(telefono));
		return "Se ha abierto la camara del telefono";
	}

	@Override
	public String hacerFoto() {
		// TODO Auto-generated method stub
		return "No es posible hacer la foto ya que se debe abrir la camara antes";
	}

}
