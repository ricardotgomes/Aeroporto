package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VooMoldel;
import to.VooTO;
import factory.TOFactory;

/**
 * Servlet implementation class ConsultarVooComprar
 */
@WebServlet("/ConsultarVooComprar.do")
public class ConsultarVooComprar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServiceLookup.setupDB();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String bilhete[] = new String[10];
		String cpf = request.getParameter("cpf");
		String nomePassageiro = request.getParameter("nomePassageiro");
		int codVoo = Integer.parseInt(request.getParameter("codVoo"));
		
		
		VooMoldel voo = new VooMoldel();
		VooTO to = TOFactory.getVooTO();
		to.codAeronave = 0;
		to.codVoo = codVoo;
		to.valorVoo = 0;
		to.dataHora = "";
		to.destino= "";
		to.escala = "";
		to.origem = "";
		
		to = voo.consultar(to);
		
		if(to != null){
		
		bilhete[0] = cpf;
		bilhete[1] = nomePassageiro;
		bilhete[2] = "" + to.codVoo;
		bilhete[3] = to.dataHora;
		bilhete[4] = to.origem;
		bilhete[5] = to.escala;
		bilhete[6] = to.destino;
		bilhete[7] = "" + to.codAeronave;
		bilhete[8] = to.nomeAeronave;
		bilhete[9] = "" + to.valorVoo;
		
	
		request.setAttribute("voo", bilhete);
		RequestDispatcher view = request.getRequestDispatcher("TelaVooComprar.jsp");
		view.forward(request, response);
		
		}else{
			RequestDispatcher view = request.getRequestDispatcher("ErroConsultaVoo.html");
			view.forward(request, response);
		}
	}

}
