package model;


import to.PassageiroTO;
import factory.DAOFactory;

public class Passageiro{

   private String cpf; 
   private String nome; 
   private String sobrenome; 
   private String endereco;
   private String telefone;
   private String email;
   private String titulo;
   
   public PassageiroTO incluir(PassageiroTO to){
		return DAOFactory.getPassageiroDAO().incluir(to);
	    
  	}
   
  	public PassageiroTO excluir(PassageiroTO to){
  		return DAOFactory.getPassageiroDAO().excluir(to);
  
   
  	}
  	public PassageiroTO consultar(PassageiroTO to){

  		return DAOFactory.getPassageiroDAO().consultar(to);

  	}
  	
  	public PassageiroTO alterar(PassageiroTO to){

  		return DAOFactory.getPassageiroDAO().alterar(to);

  	}
   
   
   public void setCpf(String cpf){
   
      this.cpf=cpf;
   }
   
   public void setNome(String nome){
   
      this.nome=nome;
   }
   
   public void setSobrenome(String sobrenome){
   
      this.sobrenome=sobrenome;
   }
   
   public void setEndereco(String endereco){
   
      this.endereco=endereco;
   }
   
   public void setTelefone(String telefone){
   
      this.telefone=telefone;
   }
   
   public void setEmail(String email){
   
      this.email=email;
   }
   
   public void setTitulo(String titulo){
   
      this.titulo=titulo;
   }
   
   public String getCpf(){
   
      return this.cpf;
   }
   
   public String getNome(){
   
      return this.nome;
   }
   
   public String getSobrenome(){
   
      return this.sobrenome;
   }
   
   public String getEndereco(){
   
      return this.endereco;
   }
   
   public String getTelefone(){
   
      return this.telefone;
   }
   
   public String getEmail(){
   
      return this.email;
   }
   public String getTitulo(){
   
      return this.titulo;
   }


}