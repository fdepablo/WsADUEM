package test;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;
import modelo.persistencia.DaoVideojuegoMySQL;
import modelo.persistencia.interfaces.DaoVideojuego;

public class TestAlta {
	public static void main(String[] args) {
		Videojuego videojuego = new Videojuego();
		videojuego.setNombre("Clash of Clans");
		videojuego.setCompañia("Supercell");
		videojuego.setPrecio(0.0);

		GestorVideojuego gestorVD = new GestorVideojuego();
		int alta = gestorVD.alta(videojuego);
		if (alta == 1)
			System.out.println("El Videojuego se dio de alta");
		else if (alta == 2)
			System.out.println("NO ALTA: ocurrió un problema en la Base de datos");
		else if (alta == 0)
			System.out.println("NO ALTA: El nombre no puedes ser menor de 5 caracteres");
		else if (alta == -1)
			System.out.println("NO ALTA: El precio debe ser mayor o igual a cero");
	}
}
