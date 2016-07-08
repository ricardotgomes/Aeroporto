package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnFactory;
import to.BilheteTO;

public class BilheteDAOMySQL extends BilheteDao{
	
	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
	@Override
	public BilheteTO incluir(BilheteTO to){  
			
			Connection conn = null;
			PreparedStatement stm = null;
			ResultSet rs = null;
	      try
	      {
	         String sqlInsert = "insert into bilhete(valordobilhete,cpfpassageiro,codvoo) values (?,?,?)";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sqlInsert);
	         stm.setInt(1, to.valorBilhete);
	         stm.setString(2, to.cpf);
	         stm.setInt(3, to.codVoo);
	         stm.executeUpdate();
	         stm.close();
	         	         
	      
	   /*  if(stm != null){
					try {
						stm.close();
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}*/
				
	      String selecao = "select LAST_INSERT_ID()";
			stm = conn.prepareStatement(selecao);
			rs = stm.executeQuery();
			if(rs.next()){
				to.numeroBilhete = rs.getInt(1);
			}
			
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm != null){
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
				to = null;
			}
			finally {
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
						to = null;
					}
				}
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
		public BilheteTO transferir(BilheteTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
	      try{
	         String sql = "update bilhete set cpfpassageiro = ? where numerobilhete = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql); 
	         stm.setString(1, to.cpf);
	         stm.setInt(2, to.numeroBilhete);
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
		public BilheteTO consultar(BilheteTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
	      
	      try{
	         String sql = "select b.numerobilhete, b.cpfpassageiro, b.codvoo, v.valorVoo, p.nome, v.origem, v.destino, v.escala, g.statuss "
	         		+ "from vendasdebilhetes.bilhete b, vendasdebilhetes.voo v, vendasdebilhetes.passageiro p, vendasdebilhetes.pagamento g "
	         		+ "where b.numerobilhete = g.numerobilhete and b.cpfpassageiro = p.cpf and b.codvoo = v.codvoo and b.numerobilhete = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql);
	         stm.setLong(1,to.numeroBilhete);
	         ResultSet resultSet = stm.executeQuery();
	      
	      
	         
	         if (resultSet.next()) { 
	            
	            to.numeroBilhete = (resultSet.getInt("numerobilhete"));
	            to.status = (resultSet.getString("statuss"));
	            to.valorBilhete = (resultSet.getInt("valorVoo"));
	            to.cpf = (resultSet.getString("cpfpassageiro"));
	            to.nome = (resultSet.getString("nome"));
	            to.codVoo = (resultSet.getInt("codvoo"));
	            to.origem = (resultSet.getString("origem"));
	            to.destino = (resultSet.getString("destino"));
	            to.escala = (resultSet.getString("escala"));
	                      
	         }
	         
	         if(to.codVoo == 0){
	        	 to = null;
	         }
	        stm.close();  
	      }
	      catch(Exception e) {
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
