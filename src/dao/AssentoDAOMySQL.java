package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnFactory;
import to.AssentoTO;


public class AssentoDAOMySQL extends AssentoDao{
	
	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
	@Override
	 public AssentoTO incluir(AssentoTO to){
		   
		 Connection conn = null;
		 PreparedStatement stm = null;
	      try
	      {
	         String sqlInsert = "insert into assento(codaeronave,fileiras,colunas) values (?,?,?)";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sqlInsert);
	         stm.setInt(1, to.codAeronave);
	         stm.setInt(2, to.qtdFileira);
	         stm.setInt(3, to.qtdColuna);
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
		public AssentoTO excluir(AssentoTO to){ 
	      
		   Connection conn = null;
		   PreparedStatement stm = null;
		   
	      try{
	    	 conn = ConnFactory.conectar();
	         String sql ="delete from assento where codaeronave = ?";
	         stm = conn.prepareStatement(sql); 
	         stm.setInt(1,to.codAeronave);
	         stm.execute();
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
		public AssentoTO alterar(AssentoTO to){
		   
		   Connection conn = null;
		   PreparedStatement stm = null;	      
		   
	      try
	      {
	         String sqlInsert = "update assento set fileiras =  ?,colunas = ? where codaeronave = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sqlInsert);
	         stm.setInt(1, to.qtdFileira);
	         stm.setInt(2, to.qtdColuna);
	         stm.setInt(3, to.codAeronave);
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
	   
	   
}
