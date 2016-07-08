package model;



import to.VooTO;
import factory.DAOFactory;




public class VooMoldel{

   private int codVoo, codAeronave, valorVoo; 
   private String origem, destino, escala, dataHora; 
  
   public VooTO incluir(VooTO to){
		return DAOFactory.getVooDAO().incluir(to);
	    
 	}
  
 	public VooTO excluir(VooTO to){
 		return DAOFactory.getVooDAO().excluir(to);
 
  
 	}
 	public VooTO consultar(VooTO to){

 		return DAOFactory.getVooDAO().consultar(to);

 	}
 	
 	public VooTO alterar(VooTO to){

 		return DAOFactory.getVooDAO().alterar(to);

 	}
 	
 	public VooTO consultarApp(VooTO to){

 		return DAOFactory.getVooDAOJSON().consultarApp(to);

 	}
   
   
      public void setCodigoVoo(int codVoo){
   
      this.codVoo=codVoo;
   }
   
   public void setCodigoAeronave(int codAeronave){
   
      this.codAeronave=codAeronave;
   }
   
   public void setOrigem(String origem){
   
      this.origem=origem;
   }
   
   public void setDestino(String destino){
   
      this.destino=destino;
   }
   
   public void setEscala(String escala){
   
      this.escala=escala;
   }
   
   public void setDataHora(String dataHora){
   
      this.dataHora=dataHora;
   }
   
   public int getCodigoVoo(){
   
      return this.codVoo;
   }
   
   public int getCodigoAeronave(){
   
      return this.codAeronave;
   }
   
   public String getOrigem(){
   
      return this.origem;
   }
   
   public String getDestino(){
   
      return this.destino;
   }
   
   public String getEscala(){
   
      return this.escala;
   }
   
   public String getDataHora(){
   
      return this.dataHora;
   }

public int getValorVoo() {
	return valorVoo;
}

public void setValorVoo(int valorVoo) {
	this.valorVoo = valorVoo;
}
}