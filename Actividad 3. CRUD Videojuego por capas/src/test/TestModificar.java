package test;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;
import modelo.persistencia.DaoVideojuegoMySQL;
import modelo.persistencia.interfaces.DaoVideojuego;

public class TestModificar {
	public static void main(String[] args) {
		Videojuego videojuego = new Videojuego();
		videojuego.setId(1);
		videojuego.setNombre("Maincra");
		videojuego.setCompa�ia("Microsoft");
		videojuego.setPrecio(24.60);

		GestorVideojuego gestorVD = new GestorVideojuego();
		int alta = gestorVD.modificar(videojuego);
		if (alta == 1)
			System.out.println("El Videojuego se modific�");
		else if (alta == 2)
			System.out.println("NO MODIFICADO: ocurri� un problema en la Base de datos");
		else if (alta == 0)
			System.out.println("NO MODIFICADO: El nombre no puedes ser menor de 5 caracteres");
		else if (alta == -1)
			System.out.println("NO MODIFICADO: El precio debe ser mayor o igual a cero");
	}
}
