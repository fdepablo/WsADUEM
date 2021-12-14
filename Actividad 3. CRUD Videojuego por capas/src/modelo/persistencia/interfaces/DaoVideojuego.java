package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Videojuego;

public interface DaoVideojuego {
	
	public boolean alta(Videojuego vd);

	public boolean baja(int id);

	public boolean modificar(Videojuego vd);

	public Videojuego obtener(int id);

	public List<Videojuego> listar();
}
