package factory;

import to.AeronaveTO;
import to.AssentoTO;
import to.BilheteTO;
import to.PagamentoCartaoCreditoTO;
import to.PagamentoCartaoDebitoTO;
import to.PassageiroTO;
import to.VooTO;


public class TOFactory {

		public static AeronaveTO getAeronaveTO(){
			return new AeronaveTO();
		}
		
		public static AssentoTO getAssentoTO(){
			return new AssentoTO();
		}
		
		public static VooTO getVooTO(){
			return new VooTO();
		}
		
		public static PagamentoCartaoCreditoTO getPagamentoCartaoCreditoTO(){
			return new PagamentoCartaoCreditoTO();
		}

		public static PagamentoCartaoDebitoTO getPagamentoCartaoDebitoTO() {
			return new PagamentoCartaoDebitoTO();
		}

		public static BilheteTO getBilheteTO(){
			return new BilheteTO();
		}
		
		public static PassageiroTO getPassageiroTO(){
			return new PassageiroTO();
		}
		
			

}
