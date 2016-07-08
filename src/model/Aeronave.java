package model;



import to.AeronaveTO;
import to.AssentoTO;
import factory.DAOFactory;
import factory.TOFactory;

public class Aeronave{

   private int cod; 
   private String nome; 
   private String tipoAeronave; 
   private int qtdColuna;
   private int qtdFileira;
   
   
   
   /*public Aeronave(int idio){
      if(idio == 0 || idio == 1){
         bn = ResourceBundle.getBundle("mensagens",new Locale("pt","BR"));
      
      }
      if (idio ==3){
         bn = ResourceBundle.getBundle("mensagens",new Locale("sp","ES"));
      }
      if(idio ==2){
         bn = ResourceBundle.getBundle("mensagens", Locale.US);
      }
      idioma=idio;
      setCodigo(0);
      setNome("");
      setTipoAeronave("");
      setQtdColuna(0);
      setQtdFileira(0);
      aeronave = new String[5];
       
   }
   
   
   public Aeronave(int cod, String nome, String tipoAeronave, int qtdColuna, int qtdFileira,int idio){
      
      if(idio == 0 || idio == 1){
         bn = ResourceBundle.getBundle("mensagens",new Locale("pt","BR"));
      
      }
      if (idio ==3){
         bn = ResourceBundle.getBundle("mensagens",new Locale("sp","ES"));
      }
      if(idio ==2){
         bn = ResourceBundle.getBundle("mensagens", Locale.US);
      }
      idioma=idio;
      setCodigo(cod);
      setNome(nome);
      setTipoAeronave(tipoAeronave);
      setQtdColuna(qtdColuna);
      setQtdFileira(qtdFileira);
      
   }*/
   
   public AeronaveTO incluir(AeronaveTO to){
		
	    AeronaveTO to2 = DAOFactory.getAeronaveDAO().incluir(to);
	    Assento assento = new Assento();
	    AssentoTO assentoto = TOFactory.getAssentoTO();
	    assentoto.codAeronave = to.cod;
		assentoto.qtdColuna = to.qtdColuna;
		assentoto.qtdFileira = to.qtdFileira;
		assentoto = assento.incluir(assentoto);   
		return to2;
      
   }
   
   public AeronaveTO excluir(AeronaveTO to){
	   
	   	Assento assento = new Assento();
	    AssentoTO assentoto = TOFactory.getAssentoTO();
	    assentoto.codAeronave = to.cod;
		assentoto = assento.excluir(assentoto);  
	   return DAOFactory.getAeronaveDAO().excluir(to);
         
         
      /*if(assento.excluir(getCodigo()).equals("OK") && aeronaveDao.excluir(getCodigo()).equals("OK")){
         return bn.getString("rotulo77");  
      } 
      else {
           
         return bn.getString("rotulo76");
      } */   
         
   }
      
      
   public AeronaveTO alterar(AeronaveTO to){
	   
	   
	   AeronaveTO to2 = DAOFactory.getAeronaveDAO().alterar(to);
	   Assento assento = new Assento();
	    AssentoTO assentoto = TOFactory.getAssentoTO();
	    assentoto.codAeronave = to.cod;
	    assentoto.qtdColuna = to.qtdColuna;
		assentoto.qtdFileira = to.qtdFileira;
		assentoto = assento.alterar(assentoto);  
      
	   return to2;
      
      /*if(aeronaveDao.alterar().equals("OK") && assento.alterar().equals("OK")){
         return bn.getString("rotulo72");  
      }
      else{
           
         return bn.getString("rotulo71"); 
      }*/
   
   }
   
   public AeronaveTO pesquisar(AeronaveTO to){
    
      
	   return DAOFactory.getAeronaveDAO().pesquisar(to);
       
   }


   
   public void setCodigo(int cod){
   
      this.cod=cod;
   }
   
   public void setNome(String nome){
   
      this.nome=nome;
   }
   
   public void setTipoAeronave(String tipoAeronave){
   
      this.tipoAeronave=tipoAeronave;
   }
   
   public void setQtdColuna(int qtdColuna){
   
      this.qtdColuna=qtdColuna;
   }
   
   public void setQtdFileira(int qtdFileira){
   
      this.qtdFileira=qtdFileira;
   }
   
   public int getCodigo(){
   
      return this.cod;
   }
   
   public String getNome(){
   
      return this.nome;
   }
   
   public String getTipoAeronave(){
   
      return this.tipoAeronave;
   }
   
   public int getQtdColuna(){
   
      return this.qtdColuna;
   }
   
   public int getQtdFileira(){
   
      return this.qtdFileira;
   }


}