package model;

import to.BilheteTO;
import factory.DAOFactory;


public class Bilhete{

   private String valorBilhete;
   private String cpf;
   private int codVoo;
   private int numeroBilhete;
    
    public BilheteTO incluir(BilheteTO to){
		return DAOFactory.getBilheteDAO().incluir(to);
	    
   }
      
   public BilheteTO transferir(BilheteTO to){
	   return DAOFactory.getBilheteDAO().transferir(to);
     
      
   }
   public BilheteTO consultar(BilheteTO to){
   
	   return DAOFactory.getBilheteDAO().consultar(to);
   
   }

   
   public void setValorBilhete(String valorBilhete){
   
      this.valorBilhete = valorBilhete;
   }
   
   public void setCpf(String cpf){
   
      this.cpf = cpf;
   }
   
   public void setCodVoo(int codVoo){
   
      this.codVoo = codVoo;
   }
   
   public int getCodVoo(){
   
      return this.codVoo;
   }
   
   public String getCpf(){
   
      return this.cpf;
   }
   
   public String getValorBilhete(){
   
      return this.valorBilhete;
   }
   
   public int getNumeroBilhete(){
      return this.numeroBilhete;
   }
   
   public void setNumeroBilhete(int numeroBilhete){
     this.numeroBilhete = numeroBilhete;
   }

   
   
   
}