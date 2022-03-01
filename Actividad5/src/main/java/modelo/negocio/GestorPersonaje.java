package modelo.negocio;

import java.util.List;

import modelo.entidad.Personaje;
import modelo.persistencia.DaoPersonaje;

public class GestorPersonaje {

	private DaoPersonaje daoPersonaje;
	
	public GestorPersonaje() {
		daoPersonaje = new DaoPersonaje();
		daoPersonaje.abrirConexion();
	}
	
	public boolean altaPersonaje(String nombre, String color) {
		if (nombre.length() <= 0) {
			return false; 
		}else {
			return daoPersonaje.altaPersonaje(nombre, color);
		}
	}
	
	public boolean bajaPersonaje(Integer id) {
		return daoPersonaje.bajaPersonaje(id);
	}
	
	public boolean buscarPersonajeID(Integer id) {
		return daoPersonaje.buscarPersonajeID(id);
	}
	
	public List<Personaje> listarPersonaje() {
		return daoPersonaje.listarPersonaje();
	}
	
	//Debemos de pasarle los datos desde la vista
	public boolean asociarPersonajeVideojuego() {
		return daoPersonaje.asociarPersonajeVideojuego();
	}
}
