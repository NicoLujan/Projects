package Iterator;

import java.util.ArrayList;

public class Usuarios implements UsuarioIterator{
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private int posicion = 0;
	
	public void crear(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	@Override
	public boolean hayMas() {
		// TODO Auto-generated method stub
		return posicion < usuarios.size();
	}

	@Override
	public void reinicia() {
		posicion = 0;		
	}

	@Override
	public Usuario siguiente() {
		// TODO Auto-generated method stub
		Usuario usuario = usuarios.get(posicion);
		posicion++;
		return usuario;
	}
	

}
