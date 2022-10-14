/*
 * Tipos de Patrones:
 * 	Creacionales
 * 	Estructurales
 * 	Comportamiento
 */

import Singleton.Singleton;
import Builder.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehiculo coche = new CocheBuilder("Filostro").setMotor("Diesel")
				.setTipo("Combustion").setPuertas(5).build();

		System.out.println(coche);
	}

}
