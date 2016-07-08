package model;

import to.PagamentoCartaoDebitoTO;
import factory.DAOFactory;

public class PagamentoCartaoDebito{

	private String contaCorrente;
   private int agencia;
   private int banco;
   private String telefone;
   
   	public PagamentoCartaoDebitoTO incluir(PagamentoCartaoDebitoTO to){
		return DAOFactory.getPagamentoCartaoDebitoDAO().incluir(to);
	    
   	}
    
   	public PagamentoCartaoDebitoTO estornar(PagamentoCartaoDebitoTO to){
   		return DAOFactory.getPagamentoCartaoDebitoDAO().estornar(to);
   
    
   	}
   	public PagamentoCartaoDebitoTO consultar(PagamentoCartaoDebitoTO to){
 
   		return DAOFactory.getPagamentoCartaoDebitoDAO().consultar(to);
 
   	}
 
   public void setContaCorrente(String contaCorrente){
   
      this.contaCorrente = contaCorrente;
   }
   
   public void setAgencia(int agencia){
   
      this.agencia = agencia;
   }
   
   public void setBanco(int banco){
   
      this.banco = banco;
   }
   
   public void setTelefone(String telefone){
   
      this.telefone = telefone;
   }
   
   public String getTelefone(){
   
      return  this.telefone;
   }
   
   public String getContaCorrente(){
   
      return  this.contaCorrente;
   }
   
   public int getBanco(){
   
      return this.banco;
   }
   
   public int getAgencia(){
   
      return this.agencia;
   }


}