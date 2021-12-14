package accesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaVideojuego extends Conexion {

	public boolean guardar(Videojuego vdj) {
		PreparedStatement ps = null;
		con = getConnection();
		String insert = "INSERT INTO VIDEOJUEGOS (NOMBRE, PRECIO, COMPANY) VALUES (?, ?, ?)";

		try {
			ps = con.prepareStatement(insert);
			ps.setString(1, vdj.getNombre());
			ps.setInt(2, vdj.getPrecio());
			ps.setString(3, vdj.getCompany());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				System.err.println(e2);
			}
		}

	}

	public boolean modificar(Videojuego vdj) {
		PreparedStatement ps = null;
		con = getConnection();
		String update = "UPDATE VIDEOJUEGOS SET NOMBRE=?, PRECIO=?, COMPANY=? WHERE ID=?";

		try {
			ps = con.prepareStatement(update);
			ps.setString(1, vdj.getNombre());
			ps.setInt(2, vdj.getPrecio());
			ps.setString(3, vdj.getCompany());
			ps.setInt(4, vdj.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				System.err.println(e2);
			}
		}

	}

	public boolean eliminar(Videojuego vdj) {

		PreparedStatement ps = null;
		con = getConnection();
		String delete = "DELETE FROM VIDEOJUEGOS WHERE ID=?";

		try {
			ps = con.prepareStatement(delete);
			ps.setInt(1, vdj.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				System.err.println(e2);
			}
		}

	}

	public boolean buscar(Videojuego vdj) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = getConnection();
		String select = "SELECT * FROM VIDEOJUEGOS WHERE NOMBRE = ?";

		try {
			ps = con.prepareStatement(select);
			ps.setString(1, vdj.getNombre());
			rs = ps.executeQuery();
			if (rs.next()) {
				vdj.setId(rs.getInt("ID"));
				vdj.setNombre(rs.getString("NOMBRE"));
				vdj.setPrecio(rs.getInt("PRECIO"));
				vdj.setCompany(rs.getString("COMPANY"));
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				System.err.println(e2);
			}
		}

	}
}
