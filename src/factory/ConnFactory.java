package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnFactory {
	private static int banco;
	public static final int MYSQL = 1;
	public static final int POSTGRE = 2;

	// o banco default e o MySQL
	public static int getBanco() {
		if (banco != MYSQL && banco != POSTGRE)
			setBanco(MYSQL);
		return banco;
	}

	public static void setBanco(int b) {
		if (b != MYSQL && b != POSTGRE)
			banco = MYSQL;
		else
			banco = b;
	}

	public static Connection conectar() throws SQLException {
		switch (banco) {
		case MYSQL:
			return ConnFactoryMySQL.conectar();
		case POSTGRE:
			return ConnFactoryPostgreSQL.conectar();
		default:
			return null;
		}
	}
}
