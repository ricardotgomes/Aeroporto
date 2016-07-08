package dao;

import java.sql.Connection;
import java.sql.SQLException;
import to.PagamentoCartaoCreditoTO;




public abstract class PagamentoCartaoCreditoDao{
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract PagamentoCartaoCreditoTO incluir(PagamentoCartaoCreditoTO to);

	public abstract PagamentoCartaoCreditoTO estornar(PagamentoCartaoCreditoTO to);
	
	public abstract PagamentoCartaoCreditoTO consultar(PagamentoCartaoCreditoTO to);
  

}