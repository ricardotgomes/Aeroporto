package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.PagamentoCartaoCreditoTO;
import factory.ConnFactory;

public class PagamentoCreditoDAOPostgreSQL extends PagamentoCartaoCreditoDao {
	
	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public PagamentoCartaoCreditoTO incluir(PagamentoCartaoCreditoTO to){  
		Connection conn = null;
		PreparedStatement stm = null;
			try
			{
				String sqlInsert = "insert into pagamento(numerobilhete,nome,cpf,numerocartao,codseg,statuss,bandeiracartao,dataVencimento) values (?,?,?,?,?,?,?,?)";
				conn = ConnFactory.conectar();
				stm = conn.prepareStatement(sqlInsert);
		         stm.setInt(1, to.numeroBilhete);
		         stm.setString(2, to.nomeTitular);
		         stm.setString(3, to.cpf);
		         stm.setString(4, to.numeroCartao);
		         stm.setInt(5, to.codigoSeguranca);
		         stm.setString(6, "Pago");
		         stm.setString(7, to.bandeira);
		         stm.setString(8, to.dataVencimento);
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
	public PagamentoCartaoCreditoTO estornar(PagamentoCartaoCreditoTO to){
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
	public PagamentoCartaoCreditoTO consultar(PagamentoCartaoCreditoTO to){
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
            to.numeroCartao = (resultSet.getString("numerocartao"));
            to.codigoSeguranca = (resultSet.getInt("codseg"));
            to.bandeira = (resultSet.getString("bandeiracartao"));
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
