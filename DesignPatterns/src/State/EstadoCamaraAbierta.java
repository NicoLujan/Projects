package State;

public class EstadoCamaraAbierta extends Estado{
	
	public EstadoCamaraAbierta(Telefono telefono) {
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
		return "El telefono ya tiene abierta la camara";
	}

	@Override
	public String hacerFoto() {
		// TODO Auto-generated method stub
		telefono.cambiaEstado(new EstadoHacerFoto(telefono));
		return "Listo para tomar la foto";
	}

}
