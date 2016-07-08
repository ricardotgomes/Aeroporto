package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.PagamentoCartaoDebitoTO;



public abstract class PagamentoCartaoDebitoDao{

	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract PagamentoCartaoDebitoTO incluir(PagamentoCartaoDebitoTO to);

	public abstract PagamentoCartaoDebitoTO estornar(PagamentoCartaoDebitoTO to);
	
	public abstract PagamentoCartaoDebitoTO consultar(PagamentoCartaoDebitoTO to);

}