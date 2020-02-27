package Programa;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class Conexion {
	
	static Connection con = null;
	static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
	static String url = "jdbc:ucanaccess://C:\\BD\\BDGestion.accdb";
	
	public static Connection obtenerconexion() {
		try {
			if (con == null) {
				Class.forName(driver);
				con=DriverManager.getConnection(url);
				//JOptionPane.showMessageDialog(null, "Conexion Correcta");
			}
		}catch (Exception e) {
			e.printStackTrace();
			con=null;
			JOptionPane.showMessageDialog(null, "Error");
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection cn = Conexion.obtenerconexion();
		
	}

}