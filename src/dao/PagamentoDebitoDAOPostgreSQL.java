package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnFactory;
import to.PagamentoCartaoDebitoTO;

public class PagamentoDebitoDAOPostgreSQL extends PagamentoCartaoDebitoDao {

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
	@Override
	 public PagamentoCartaoDebitoTO incluir(PagamentoCartaoDebitoTO to){  
		 Connection conn = null;
		 PreparedStatement stm = null;
	      try
	      {
	         String sqlInsert = "insert into pagamento(numerobilhete,nome,cpf,contacorrente,agencia,telefone,banco,statuss) values (?,?,?,?,?,?,?,?)";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sqlInsert);
	         stm.setInt(1, to.numeroBilhete);
	         stm.setString(2, to.nomeTitular);
	         stm.setString(3, to.cpf);
	         stm.setString(4, to.contaCorrente);
	         stm.setString(5, to.agencia);
	         stm.setString(6, to.banco);
	         stm.setString(7, to.telefone);
	         stm.setString(8, "Pago");
	         
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
	   public PagamentoCartaoDebitoTO estornar(PagamentoCartaoDebitoTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
		   try{
	         String sql = "update pagamento set statuss =  ? where numerobilhete = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql); 
	         stm.setString(1, "Estornado");
	         stm.setInt(2, to.numeroBilhete);
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
	   public PagamentoCartaoDebitoTO consultar(PagamentoCartaoDebitoTO to){
		   Connection conn = null;
		   PreparedStatement stm = null;
	      
	      try{
	         String sql = "select * from pagamento where numerobilhete = ?";
	         conn = ConnFactory.conectar();
	         stm = conn.prepareStatement(sql);
	         stm.setLong(1,to.numeroBilhete);
	         ResultSet resultSet = stm.executeQuery();
	      
	         
	         if (resultSet.next()) { 
	            to.cpf = (resultSet.getString("cpf"));
	            to.nomeTitular = (resultSet.getString("nome"));
	            to.contaCorrente = (resultSet.getString("contacorrente"));
	            to.agencia = (resultSet.getString("agencia"));
	            to.banco = (resultSet.getString("banco"));
	            to.telefone = (resultSet.getString("telefone"));
	            to.status = (resultSet.getString("statuss"));
	         
	           
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
