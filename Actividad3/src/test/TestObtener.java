package test;

import java.util.Iterator;
import java.util.List;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;
import modelo.persistencia.DaoVideojuegoMySQL;
import modelo.persistencia.interfaces.DaoVideojuego;

public class TestObtener {
	public static void main(String[] args) {
		GestorVideojuego gestorDV = new GestorVideojuego();
		Videojuego videojuego = gestorDV.obtener(2);
		System.out.println(videojuego);

		System.out.println("********** LISTANDO TODOS LOS VIDEOJUEGOS POR COMPAÑIA: **********");
		List<Videojuego> listaVideojuegos = gestorDV.listar();
		for (Videojuego v : listaVideojuegos) {
			System.out.println(v);
		}
	}
}
