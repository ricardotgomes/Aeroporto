package factory;


import dao.AeronaveDAO;
import dao.AeronaveDAOMySQL;
import dao.AeronaveoDAOPostgreSQ;
import dao.AssentoDAOMySQL;
import dao.AssentoDAOPostgreSQL;
import dao.AssentoDao;
import dao.BilheteDAOMySQL;
import dao.BilheteDAOPostgreSQL;
import dao.BilheteDao;
import dao.PagamentoCartaoCreditoDao;
import dao.PagamentoCartaoDebitoDao;
import dao.PagamentoCreditoDAOMySQL;
import dao.PagamentoCreditoDAOPostgreSQL;
import dao.PagamentoDebitoDAOMySQL;
import dao.PagamentoDebitoDAOPostgreSQL;
import dao.PassageiroDAOMySQL;
import dao.PassageiroDAOPostgreSQL;
import dao.PassageiroDao;
import dao.VooDAOMySQL;
import dao.VooDAOPostgreSQL;
import dao.VooDao;




public class DAOFactory {

	public static AeronaveDAO getAeronaveDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new AeronaveDAOMySQL();
		case ConnFactory.POSTGRE:
			return new AeronaveoDAOPostgreSQ();
		default:
			return null;
		}
	}
	
	public static AssentoDao getAssentoDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new AssentoDAOMySQL();
		case ConnFactory.POSTGRE:
			return new AssentoDAOPostgreSQL();
		default:
			return null;
		}
	}
	
	public static BilheteDao getBilheteDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new BilheteDAOMySQL();
		case ConnFactory.POSTGRE:
			return new BilheteDAOPostgreSQL();
		default:
			return null;
		}
	}
	
	public static PagamentoCartaoCreditoDao getPagamentoCartaoCreditoDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new PagamentoCreditoDAOMySQL();
		case ConnFactory.POSTGRE:
			return new PagamentoCreditoDAOPostgreSQL();
		default:
			return null;
		}
	}
	
	public static PagamentoCartaoDebitoDao getPagamentoCartaoDebitoDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new PagamentoDebitoDAOMySQL();
		case ConnFactory.POSTGRE:
			return new PagamentoDebitoDAOPostgreSQL();
		default:
			return null;
		}
	}
	
	public static PassageiroDao getPassageiroDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new PassageiroDAOMySQL();
		case ConnFactory.POSTGRE:
			return new PassageiroDAOPostgreSQL();
		default:
			return null;
		}
	}
	
	public static VooDao getVooDAO() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			return new VooDAOMySQL();
		case ConnFactory.POSTGRE:
			return new VooDAOPostgreSQL();
		default:
			return null;
		}
	}
	
	public static VooDao getVooDAOJSON() {
		switch (ConnFactory.getBanco()) {
		case ConnFactory.MYSQL:
			
			return new VooDAOMySQL();
		case ConnFactory.POSTGRE:
		new VooDAOPostgreSQL();
			return new VooDAOPostgreSQL();
		default:
			return null;
		}
	}
	
}
