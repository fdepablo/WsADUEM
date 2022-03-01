package modelo.negocio;

import java.util.List;


import modelo.entidad.Videojuego;
import modelo.persistencia.DaoVideojuego;

public class GestorVideojuego {
	
	private DaoVideojuego daoVideojuego;
	
	public GestorVideojuego() {
		daoVideojuego = new DaoVideojuego();
		daoVideojuego.abrirConexion();
	}
	
	public boolean altaVideojuego(String nombre, String company, Integer nota) {
		if (nombre.length() <= 0) {
			return false;
		} else {
			return daoVideojuego.altaVideojuego(nombre, company, nota);
		}
	}

	public boolean bajaVideojuegoID(Integer id) {
		return daoVideojuego.bajaVideojuego(id);
	}

	public boolean buscarVideojuego(Integer id) {
		return daoVideojuego.buscarVideojuegoID(id);
	}

	public List<Videojuego> listarVideojuego() {
		return daoVideojuego.listarVideojuego();
	}
	
	//Tendriamos que recoger los datos de la vista y pasarlos por aqui
	//al gestor
	public boolean asociarVideojuegoPersonaje() {
		//y pasarle los datos al dao
		return daoVideojuego.asociarVideojuegoPersonaje();	
	}
}
