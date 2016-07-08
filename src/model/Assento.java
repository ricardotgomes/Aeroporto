package model;

import to.AssentoTO;
import factory.DAOFactory;


public class Assento{

   private int codAeronave;
   private int qtdColuna;
   private int qtdFileira;
   
   public int getCodAeronave() {
	return codAeronave;
}

public void setCodAeronave(int codAeronave) {
	this.codAeronave = codAeronave;
}

public int getQtdColuna() {
	return qtdColuna;
}

public void setQtdColuna(int qtdColuna) {
	this.qtdColuna = qtdColuna;
}

public int getQtdFileira() {
	return qtdFileira;
}

public void setQtdFileira(int qtdFileira) {
	this.qtdFileira = qtdFileira;
}

public AssentoTO incluir(AssentoTO to){
		return DAOFactory.getAssentoDAO().incluir(to);
	    
   }
      
   public AssentoTO excluir(AssentoTO to){
	   return DAOFactory.getAssentoDAO().excluir(to);
     
      
   }
   public AssentoTO alterar(AssentoTO to){
   
	   return DAOFactory.getAssentoDAO().alterar(to);
   
   }
   
   
}