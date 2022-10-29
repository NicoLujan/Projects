package Strategy;

import java.util.ArrayList;

public class UsuariosMemoria implements UsuariosStrategy{
	private ArrayList<String> usuarios = new ArrayList<String>();
	
	public void crear(String nombre) {
		usuarios.add(nombre);
	}
	
	public ArrayList<String> listar(){
		return usuarios;
	}

}
