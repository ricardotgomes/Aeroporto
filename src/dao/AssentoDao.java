package dao;

import java.sql.SQLException;
import java.sql.Connection;

import to.AssentoTO;




public abstract class AssentoDao{
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract AssentoTO incluir(AssentoTO to);

	public abstract AssentoTO excluir(AssentoTO to);
	
	public abstract AssentoTO alterar(AssentoTO to);
	

}