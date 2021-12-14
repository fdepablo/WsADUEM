package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

	String cadenaConexion = "jdbc:mysql://localhost:3306/coche";
	String user = "root";
	String pass = "";

	//Insertar
	public void Insertar(int id, String marca, String modelo,int km) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)) {
			String sql = "INSERT INTO VEHICULO (id, marca, modelo, kilometros) VALUES (?, ?, ?, ?)";

			System.out.println("Se va a ejecutar la sentencia SQL de insercción:");

			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);

			sentencia.setInt(1, id);
			sentencia.setString(2, marca);
			sentencia.setString(3, modelo);
			sentencia.setInt(4, km);

			sentencia.executeUpdate();//diferencia update y quary
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("\n");
		} catch (SQLException e) {
			System.out.println("Error al añadir un nuevo vehiculo");
			System.out.println(e.getMessage());
		}
	}
	
	//Leer
	public void Leer() {
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)) {
			String sql = "Select * From VEHICULO";

			System.out.println("Se va a ejecutar la sentencia SQL de lectura:");

			PreparedStatement sentencia = con.prepareStatement(sql);

			ResultSet rs = sentencia.executeQuery();//no cambia registros, se usa para consultas
			while (rs.next()) {//preguntamos si hay mas filas
				System.out.print(rs.getInt("id"));//DAME EL VALOR DE LA COLUMNA ID
				System.out.print(" - "); 
				System.out.print(rs.getString("marca"));
				System.out.print(" - "); 
				System.out.print(rs.getString("modelo"));
				System.out.print(" - "); 
				System.out.print(rs.getInt("Kilometros"));
				System.out.println(); 
			}
			sentencia.executeQuery();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("\n");

		} catch (SQLException e) {
			System.out.println("Error al leer los vehiculos");
			System.out.println(e.getMessage());
		}
	}
	
	//Actualizar
	public void Actualizar(String marca, String modelo, int km, int id) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)) {
				String sql = "update VEHICULO set marca=?, modelo=?, kilometros=? WHERE id=?";
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, marca);
			sentencia.setString(2, modelo);
			sentencia.setInt(3, km);
			sentencia.setInt(4, id);
			
			sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("\n");
		
		} catch (SQLException e) {
			System.out.println("Error al modificar un nuevo vehiculo");
			System.out.println(e.getMessage());
		}
	}
	
	//Borrar
	public void Borrar(int id) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)) {
			String sql = "DELETE FROM VEHICULO WHERE ID=?"; 
				
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setInt(1, id);
			
			sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("\n");
		
		} catch (SQLException e) {
			System.out.println("Error al eliminar un nuevo vehiculo");
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
