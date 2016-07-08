package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import jdk.nashorn.internal.parser.JSONParser;

import org.json.JSONObject;





import factory.TOFactory;
import model.VooMoldel;
import to.VooTO;

/**
 * Servlet implementation class ConsultarVooJSON
 */
@WebServlet("/ConsultarVooJSON.do")
public class ConsultarVooJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject jsonObject;
		JSONParser parser = new JSONParser(null,null);
		
		String origem;
		String destino;
		
		
		try{
		jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));
		origem =(String) jsonObject.get("origem");
		destino =(String) jsonObject.get("destino");
		
		
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
		e.printStackTrace();
		}catch (ParseException e) {
			
			e.printStackTrace();
			
		}
		
		VooMoldel voo = new VooMoldel();
		VooTO vooTO = TOFactory.getVooTO();
		vooTO.destino = destino;
		vooTO.origem = origem;
		ArrayList<VooTO> array = voo.consultarAPP(vooTO);
		response.setCharacterEncoding("UTF-8");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// inserir um novo voo
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// alterar um voo
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// deletar um voo
	}
	
	@Override
	public void init(ServletConfig config){
		
		ServiceLookup.setupDB();
	}

}
