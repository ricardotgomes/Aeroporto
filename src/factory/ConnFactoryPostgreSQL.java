package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactoryPostgreSQL extends ConnFactory {
	static{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:postgre://127.0.0.1:3306/vendasdebilhetes","root","lusalusa");
	}

}
