package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.PassageiroTO;
import factory.ConnFactory;

public class PassageiroDAOPostgreSQL extends PassageiroDao {
	
	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	@Override	
	public PassageiroTO incluir(PassageiroTO to){  
		 Connection conn = null;
		 PreparedStatement stm = null;
	      try
	      {
	         String sqlInsert = "insert into passageiro(cpf,nome,sobrenome,endereco,telefone,email,titulo) values (?,?,?,?,?,?,?)";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sqlInsert);
	         stm.setString(1, to.cpf);
	         stm.setString(2, to.nome);
	         stm.setString(3, to.sobrenome);
	         stm.setString(4, to.endereco);
	         stm.setString(5, to.telefone);
	         stm.setString(6, to.email);
	         stm.setString(7, to.titulo);
	         
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
		public PassageiroTO excluir(PassageiroTO to){ 
		   Connection conn = null;
		   PreparedStatement stm = null;
	      try{
	         String sql ="delete from passageiro where cpf = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql); 
	         stm.setString(1,to.cpf); 
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
		public PassageiroTO alterar(PassageiroTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
	      try{
	         String sql = "update passageiro set nome =  ?,sobrenome = ?, endereco = ?, telefone = ?, email = ?, titulo = ? where cpf = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql); 
	         stm.setString(1, to.nome);
	         stm.setString(2, to.sobrenome);
	         stm.setString(3, to.endereco);
	         stm.setString(4, to.telefone);
	         stm.setString(5, to.email);
	         stm.setString(6, to.titulo);
	         stm.setString(7, to.cpf);
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
		public PassageiroTO consultar(PassageiroTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
	      
	      try{
	         String sql = "select * from passageiro where cpf = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql);
	         stm.setString(1,to.cpf);
	         ResultSet resultSet = stm.executeQuery();
	         
	         if (resultSet.next()) { 
	            to.cpf = (resultSet.getString("cpf"));
	            to.nome = (resultSet.getString("nome"));
	            to.sobrenome = (resultSet.getString("sobrenome"));
	            to.endereco = (resultSet.getString("endereco"));
	            to.telefone = (resultSet.getString("telefone"));
	            to.email = (resultSet.getString("email"));
	            to.titulo = (resultSet.getString("titulo"));
	           
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

}
