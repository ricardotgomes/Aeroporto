package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.AeronaveTO;


public abstract class AeronaveDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract AeronaveTO incluir(AeronaveTO to);

	public abstract AeronaveTO excluir(AeronaveTO to);
	
	public abstract AeronaveTO alterar(AeronaveTO to);
	
	public abstract AeronaveTO pesquisar(AeronaveTO to);
}
