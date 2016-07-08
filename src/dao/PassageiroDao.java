package dao;

import java.sql.SQLException;
import java.sql.Connection;
import to.PassageiroTO;


public abstract class PassageiroDao{
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract PassageiroTO incluir(PassageiroTO to);

	public abstract PassageiroTO excluir(PassageiroTO to);
	
	public abstract PassageiroTO alterar(PassageiroTO to);
	
	public abstract PassageiroTO consultar(PassageiroTO to);

   

}