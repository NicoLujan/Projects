/*
 * El patrón Decorator responde a la necesidad de añadir dinámicamente funcionalidad a un Objeto. Esto nos 
 * permite no tener que crear sucesivas clases que hereden de la primera incorporando la nueva 
 * funcionalidad, sino otras que la implementan y se asocian a la primera.
 * 
 */
package Decorator;

public class TelefonoDecorator implements Telefono{
	
	private Telefono telefono;
	
	public TelefonoDecorator(Telefono telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public void crear() {
		// TODO Auto-generated method stub
		this.telefono.crear();		
	}

}
