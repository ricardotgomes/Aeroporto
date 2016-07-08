package model;

import to.PagamentoCartaoCreditoTO;
import factory.DAOFactory;


public class PagamentoCartaoCredito{

   private String numeroCartao;
   private int codigoSeguranca;
   private String bandeira;
    
   
   public PagamentoCartaoCreditoTO incluir(PagamentoCartaoCreditoTO to){
		return DAOFactory.getPagamentoCartaoCreditoDAO().incluir(to);
	    
  }
     
  public PagamentoCartaoCreditoTO estornar(PagamentoCartaoCreditoTO to){
	   return DAOFactory.getPagamentoCartaoCreditoDAO().estornar(to);
    
     
  }
  public PagamentoCartaoCreditoTO consultar(PagamentoCartaoCreditoTO to){
  
	   return DAOFactory.getPagamentoCartaoCreditoDAO().consultar(to);
  
  }
  
   public void setNumeroCartao(String numeroCartao){
   
      this.numeroCartao = numeroCartao;
   }
   
   public void setCodigoSeguranca(int codigoSeguranca){
   
      this.codigoSeguranca = codigoSeguranca;
   }
   
   public void setBandeira(String bandeira){
   
      this.bandeira = bandeira;
   }
   
   public String getBandeira(){
   
      return  this.bandeira;
   }
   
   public String getNumeroCartao(){
   
      return  this.numeroCartao;
   }
   
   public int getCodigoSeguranca(){
   
      return this.codigoSeguranca;
   }


}