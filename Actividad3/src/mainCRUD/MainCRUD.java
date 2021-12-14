package mainCRUD;

import accesoDatos.ConsultaVideojuego;
import accesoDatos.Videojuego;
import logica.LgProducto;
import vista.CRUD;

public class MainCRUD {

	public static void main(String[] args) {
		
		Videojuego vdj = new Videojuego();
		ConsultaVideojuego vdjC = new ConsultaVideojuego();
		CRUD vista = new CRUD();
		
		LgProducto lgP = new LgProducto(vdj, vdjC, vista);
		lgP.iniciar();
		vista.setVisible(true);
		
	}

}
