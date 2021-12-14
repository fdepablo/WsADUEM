package test;

import modelo.negocio.GestorVideojuego;
import modelo.persistencia.DaoVideojuegoMySQL;
import modelo.persistencia.interfaces.DaoVideojuego;

public class TestBaja {
	public static void main(String[] args) { 
		GestorVideojuego gestorVD = new GestorVideojuego();

		boolean baja = gestorVD.baja(2);
		if (baja)
			System.out.println("El Videojuego se dió de baja");
		else
			System.out.println("El Videojuego NO se dió de baja");
	}
}
