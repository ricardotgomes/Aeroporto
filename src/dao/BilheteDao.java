package dao;

import java.sql.SQLException;
import java.sql.Connection;

import to.BilheteTO;


public abstract class BilheteDao{
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract BilheteTO incluir(BilheteTO to);

	public abstract BilheteTO transferir(BilheteTO to);
	
	public abstract BilheteTO consultar(BilheteTO to);
    
   
   
}