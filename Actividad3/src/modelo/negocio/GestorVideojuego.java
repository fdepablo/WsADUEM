package modelo.negocio;

import java.util.Collections;
import java.util.List;

import modelo.entidad.Videojuego;
import modelo.persistencia.DaoVideojuegoMySQL;
import modelo.persistencia.interfaces.DaoVideojuego;

public class GestorVideojuego {

	private DaoVideojuego daoVideojuego = new DaoVideojuegoMySQL();

	private boolean verificarNombreVD(Videojuego vd) {
		// Se requiere que al menos el nombre no pueda ser menor de 5 caracteres.
		if (vd.getNombre().length() >= 5)
			return true;
		else
			return false;
	}

	private boolean verificarPrecioVD(Videojuego vd) {
		// Se requeire que el precio no pueda ser negativo.
		if (vd.getPrecio() >= 0)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param vd
	 * @return
	 */
	public int alta(Videojuego vd) {
		int respuesta = 0;// respuesta -> 0: el nombre es menor a 5 caracteres
		if (verificarNombreVD(vd) && verificarPrecioVD(vd)) {
			boolean alta = daoVideojuego.alta(vd);
			// respuesta -> 1: es que se dio de alta
			// respuesta -> 2: es que NO se dio de alta (Problema en BBDD)
			respuesta = (alta) ? 1 : 2;
		} else if (!verificarPrecioVD(vd)) {
			respuesta = -1;// respuesta -> -1: es el precio es menor que 0
		}

		return respuesta;
	}

	public int modificar(Videojuego vd) {
		int respuesta = 0;// respuesta -> 0: el nombre es menor a 5 caracteres
		if (verificarNombreVD(vd) && verificarNombreVD(vd)) {
			boolean alta = daoVideojuego.modificar(vd);
			// respuesta -> 1: es que se modificó
			// respuesta -> 2: es que NO se modificó (Problema en BBDD)
			respuesta = (alta) ? 1 : 2;
		} else if (!verificarPrecioVD(vd)) {
			respuesta = -1;// respuesta -> -1: es el precio es menor que 0
		}

		return respuesta;
	}

	public boolean baja(int id) {
		boolean baja = daoVideojuego.baja(id);
		return baja;
	}

	public Videojuego obtener(int id) {
		Videojuego videojuego = daoVideojuego.obtener(id);
		return videojuego;
	}

	public List<Videojuego> listar() {
		List<Videojuego> listaVideojuegos = daoVideojuego.listar();
		Collections.sort(listaVideojuegos);
		return listaVideojuegos;
	}
}
