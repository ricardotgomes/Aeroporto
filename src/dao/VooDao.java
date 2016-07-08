package dao;

import java.sql.SQLException;
import java.sql.Connection;
import to.VooTO;


public abstract class VooDao{

	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract VooTO incluir(VooTO to);

	public abstract VooTO excluir(VooTO to);
	
	public abstract VooTO alterar(VooTO to);
	
	public abstract VooTO consultar(VooTO to);
	
	public abstract VooTO consultarApp(VooTO to);
}