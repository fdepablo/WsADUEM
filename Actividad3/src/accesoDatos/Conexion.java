package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	private final static String url = "jdbc:mysql://localhost:3306/tareas";
	private final static String username = "root";
	private final static String password = "";
	protected static Connection con = null;

	public static Connection getConnection() {


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection)DriverManager.getConnection(url, username, password);
			JOptionPane.showMessageDialog(null, "Conexion Exitosa");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return con;
	}
}
