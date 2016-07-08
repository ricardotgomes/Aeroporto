package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactoryMySQL extends ConnFactory {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(
		"jdbc:mysql://127.0.0.1:3306/vendasdebilhetes","root","lusalusa");
	}
}
