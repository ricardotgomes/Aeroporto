package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnFactory;
import to.AeronaveTO;

public class AeronaveDAOMySQL extends AeronaveDAO {
	
	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
	@Override
	public AeronaveTO incluir(AeronaveTO to){  
	      
	      
	        Connection conn = null;
			PreparedStatement stm = null;
			
	      try
	      {
	         String sqlInsert = "insert into aeronave(codaeronave,nome,tipoaeronave) values (?,?,?)";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sqlInsert);
	         stm.setInt(1, to.cod);
	         stm.setString(2, to.nome);
	         stm.setString(3, to.tipoAeronave);
	         stm.executeUpdate();
	         stm.close();
	         
	         
	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();
	    	  to = null;
	      }finally {
				if(stm != null){
					try {
						stm.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
				if(conn != null){
					try {
						desconectar(conn);
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
			}  
	           
	      return to;
	   
	   }
	   
		@Override
		public AeronaveTO excluir(AeronaveTO to){ 
	    
	      
	        Connection conn = null;
			PreparedStatement stm = null;
			
	      try{
	    	 conn = ConnFactory.conectar();
	         String sql ="delete from aeronave where codaeronave = ?";
	         stm = conn.prepareStatement(sql); 
	         stm.setInt(1,to.cod); 
	         stm.execute();
	         stm.close();
	         
	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();
	    	  to = null;
	      }
			finally {
				if(stm != null){
					try {
						stm.close();
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
				if(conn != null){
					try {
						desconectar(conn);
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
			} 
	      return to;
	   }
	   
		@Override
		public AeronaveTO alterar(AeronaveTO to){
	    
	        Connection conn = null;
			PreparedStatement stm = null;
			
	      try{
	    	 conn = ConnFactory.conectar();
	         String sql = "update aeronave set nome =  ?,tipoaeronave = ? where codaeronave = ?";
	         stm = conn.prepareStatement(sql); 
	         stm.setString(1, to.nome);
	         stm.setString(2, to.tipoAeronave);
	         stm.setInt(3, to.cod);
	         stm.executeUpdate();
	         stm.close(); 
	        
	      }
	      catch(Exception e){
	                 
	    	  e.printStackTrace();
	    	  to = null;
	      } 
			finally {
				
				if(stm  != null){
					try {
						stm.close();
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
				if(conn != null){
					try {
						desconectar(conn);
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
			}

	      return to;  
	   }
		
		@Override
		public AeronaveTO pesquisar(AeronaveTO to){
	      
	      Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
			String sql = "select a.codaeronave, a.nome, a.tipoAeronave, s.fileiras, s.colunas "+
					 "from vendasdebilhetes.aeronave a, vendasdebilhetes.assento s "+
					 "where a.codaeronave = s.codaeronave "+
					 "and a.codaeronave = ?";
			
			
	      try{
	         
	         conn = ConnFactory.conectar();
				stm = conn.prepareStatement(sql);
				stm.setInt(1, to.cod);
				rs = stm.executeQuery();
				if(rs.next()){
					to.cod = rs.getInt(1);
					to.nome = rs.getString(2);
					to.tipoAeronave = rs.getString(3);
					to.qtdFileira = rs.getInt(4);
					to.qtdColuna = rs.getInt(5);
								}
	         stm.close(); 
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	         to = null;
	      }
	      finally {
	    	  if(rs  != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
				if(stm  != null){
					try {
						stm.close();
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
				if(conn != null){
					try {
						desconectar(conn);
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
			}
	      return to; 
	   }



	

}
