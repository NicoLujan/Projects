package Strategy;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		
		UsuariosStrategy usuarios;
		
		if(i == 0) {
			usuarios = new UsuariosMemoria();
		}else {
			usuarios = new UsuariosFichero();
		}
		
		crear(usuarios,"Mengano");
		crear(usuarios,"Juanito");
		crear(usuarios,"Pepe");
		crear(usuarios,"Robertito");
		
		for(String usuario : listar(usuarios)) {
			System.out.println(usuario);
		}

	}
	
	public static void crear(UsuariosStrategy usuarios, String nombre) {
		usuarios.crear(nombre);
	}
	public static ArrayList<String> listar(UsuariosStrategy usuarios){
		return usuarios.listar();
	}

}
