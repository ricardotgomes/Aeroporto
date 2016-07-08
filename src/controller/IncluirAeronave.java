package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aeronave;
import to.AeronaveTO;
import factory.TOFactory;

/**
 * Servlet implementation class IncluirAeronave
 */
@WebServlet("/IncluirAeronave.do")
public class IncluirAeronave extends HttpServlet {
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
		
		int cod = Integer.parseInt(request.getParameter("cod"));
		String nomeAeronave = request.getParameter("nomeAeronave");
		int qtdColuna = Integer.parseInt(request.getParameter("qtdColuna"));
		int qtdFileira = Integer.parseInt(request.getParameter("qtdFileira"));
		String tipoAeronave = request.getParameter("tipoAeronave");
		
		Aeronave aeronave = new Aeronave();
		AeronaveTO to = TOFactory.getAeronaveTO();
		to.cod = cod;
		to.nome = nomeAeronave;
		to.qtdColuna = qtdColuna;
		to.qtdFileira = qtdFileira;
		to.tipoAeronave = tipoAeronave;
		to = aeronave.incluir(to);
		
		if(to != null){
		request.setAttribute("aeronave", to);
		RequestDispatcher view = request.getRequestDispatcher("TelaAeronaveIncluida.jsp");
		view.forward(request, response);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("ErroIncluirAeronave.html");
			view.forward(request, response);
		}
	}

}
