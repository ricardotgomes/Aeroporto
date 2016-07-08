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
 * Servlet implementation class AlterarAeronaveConsultar
 */
@WebServlet("/AlterarAeronaveConsultar.do")
public class AlterarAeronaveConsultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		
		Aeronave aeronave = new Aeronave();
		AeronaveTO to = TOFactory.getAeronaveTO();
		to.cod = cod;
		to.nome = "";
		to.qtdColuna = 0;
		to.qtdFileira = 0;
		to.tipoAeronave = "";
		to = aeronave.pesquisar(to);
		
		if(to != null){
			request.setAttribute("aeronave", to);
			RequestDispatcher view = request.getRequestDispatcher("TelaDadosConsultaAeronave.jsp");
			view.forward(request, response);
			}else {
				RequestDispatcher view = request.getRequestDispatcher("ErroConsultaAeronave.html");
				view.forward(request, response);
				
			}
		
		
	}

}
