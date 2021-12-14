package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Videojuego;
import modelo.persistencia.interfaces.DaoVideojuego;

public class DaoVideojuegoMySQL implements DaoVideojuego {

	private Connection conexion;

	public boolean abrirConexion() {
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean alta(Videojuego vd) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		String query = "insert into videojuegos (nombre,compañia,precio) values(?,?,?)";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, vd.getNombre());
			ps.setString(2, vd.getCompañia());
			ps.setDouble(3, vd.getPrecio());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				alta = false;
		} catch (Exception e) {
			System.out.println("alta -> Error al insertar: " + vd);
			alta = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return alta;
	}

	@Override
	public boolean baja(int id) {
		if (!abrirConexion()) {
			return false;
		}

		boolean borrado = true;

		String query = "delete from videojuegos where id = ?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja" + " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return borrado;
	}

	@Override
	public boolean modificar(Videojuego vd) {
		if (!abrirConexion()) {
			return false;
		}
		boolean modificado = true;

		String query = "update videojuegos set nombre=?, compañia=?, precio=? where id=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, vd.getNombre());
			ps.setString(2, vd.getCompañia());
			ps.setDouble(3, vd.getPrecio());
			ps.setInt(4, vd.getId());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				modificado = false;
		} catch (Exception e) {
			System.out.println("modificar -> error al modificar la " + " persona " + vd);
			modificado = false;
		} finally {
			cerrarConexion();
		}

		return modificado;
	}

	@Override
	public Videojuego obtener(int id) {
		if (!abrirConexion()) {
			return null;
		}
		Videojuego videojuego = null;

		String query = "select * from videojuegos where id=?";

		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				videojuego = new Videojuego();
				videojuego.setId(rs.getInt(1));
				videojuego.setNombre(rs.getString(2));
				videojuego.setCompañia(rs.getString(3));
				videojuego.setPrecio(rs.getDouble(4));
			}
		} catch (Exception e) {
			System.out.println("obtener -> error al obtener la " + "persona con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return videojuego;
	}

	@Override
	public List<Videojuego> listar() {
		if (!abrirConexion()) {
			return null;
		}
		List<Videojuego> listaVideojuegos = new ArrayList<>();

		String query = "select * from videojuegos";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Videojuego videojuego = new Videojuego();
				videojuego.setId(rs.getInt(1));
				videojuego.setNombre(rs.getString(2));
				videojuego.setCompañia(rs.getString(3));
				videojuego.setPrecio(rs.getDouble(4));

				listaVideojuegos.add(videojuego);
			}
		} catch (Exception e) {
			System.out.println("listar -> error al obtener las " + "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return listaVideojuegos;
	}
}
