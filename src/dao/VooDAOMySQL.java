package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnFactory;
import to.VooTO;

public class VooDAOMySQL extends VooDao{
	
	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
	@Override
	public VooTO incluir(VooTO to){  
		Connection conn = null;
		PreparedStatement stm = null;
	      try
	      {
	         String sqlInsert = "insert into voo(codvoo,origem,escala,destino,data,codaeronave,valorVoo) values (?,?,?,?,?,?,?)";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sqlInsert);
	         stm.setInt(1, to.codVoo);
	         stm.setString(2, to.origem);
	         stm.setString(3, to.escala);
	         stm.setString(4, to.destino);
	         stm.setString(5, to.dataHora);
	         stm.setInt(6, to.codAeronave);
	         stm.setInt(7, to.valorVoo);
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
	public VooTO excluir(VooTO to){ 
	    	Connection conn = null;
	    	PreparedStatement stm = null;
	    	try{
	         String sql ="delete from voo where codvoo = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql); 
	         stm.setInt(1,to.codVoo); 
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
	   	public VooTO alterar(VooTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
		   try{
	         String sql = "update voo set origem =  ?,escala = ?, destino = ?, data = ?, codaeronave = ?, valorVoo = ? where codvoo = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql); 
	         stm.setString(1, to.origem);
	         stm.setString(2, to.escala);
	         stm.setString(3, to.destino);
	         stm.setString(4, to.dataHora);
	         stm.setInt(5, to.codAeronave);
	         stm.setInt(6, to.valorVoo);
	         stm.setInt(7, to.codVoo);
	         stm.executeUpdate();
	         stm.close(); 
		   }
		   catch(Exception e){
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
		public VooTO consultar(VooTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
	      
		   try{
	         String sql = "select v.codVoo, v.origem, v.escala, v.destino, v.data, "+
		     "v.codaeronave, v.valorVoo, a.nome "+
		     "from vendasdebilhetes.voo v, vendasdebilhetes.aeronave a "+
		     "where v.codaeronave = a.codaeronave " +
	         "and codVoo = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql);
	         stm.setLong(1,to.codVoo);
	         ResultSet resultSet = stm.executeQuery();
	         
	         if (resultSet.next()) {
	            to.codVoo = (resultSet.getInt("codvoo"));
	            to.origem = (resultSet.getString("origem"));
	            to.escala = (resultSet.getString("escala"));
	            to.destino = (resultSet.getString("destino"));
	            to.dataHora = (resultSet.getString("data"));
	            to.codAeronave = (resultSet.getInt("codaeronave"));
	            to.valorVoo = (resultSet.getInt("valorVoo"));
	            to.nomeAeronave = (resultSet.getString("nome"));
	           
	         }
	         stm.close(); 
		   }
		   catch(Exception e) {
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
		public ArrayList<VooTO> consultarApp(VooTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
		   ArrayList<VooTO> voo = new ArrayList<VooTO>();
	      
		   try{
	         String sql = "select * from voo where destino = ? and origem = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql);
	         stm.setString(1,to.destino);
	         stm.setString(2, to.origem);
	         ResultSet resultSet = stm.executeQuery();
	         
	         if (resultSet.next()) {
	            to.codVoo = (resultSet.getInt("codvoo"));
	            to.origem = (resultSet.getString("origem"));
	            to.escala = (resultSet.getString("escala"));
	            to.destino = (resultSet.getString("destino"));
	            to.dataHora = (resultSet.getString("data"));
	            to.codAeronave = (resultSet.getInt("codaeronave"));
	            to.valorVoo = (resultSet.getInt("valorVoo"));
	            voo.add(to);
	           
	         }
	         stm.close(); 
		   }
		   catch(Exception e) {
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
		   	return voo; 
	   }
}
