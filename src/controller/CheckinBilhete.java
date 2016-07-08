package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bilhete;
import to.BilheteTO;
import factory.TOFactory;

/**
 * Servlet implementation class CheckinBilhete
 */
@WebServlet("/CheckinBilhete.do")
public class CheckinBilhete extends HttpServlet {
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
		
		int numeroBilhete = Integer.parseInt(request.getParameter("numeroBilhete"));
		
		
		Bilhete bilhete = new Bilhete();
		BilheteTO to = TOFactory.getBilheteTO();
		
		to.numeroBilhete = numeroBilhete;
		to.codVoo = 0;
		to.cpf = "";
		to.status = "";
		to.valorBilhete = 0;	
		to.destino = "";
		to.escala = "";
		to.nome = "";
		to.origem = "";
				
		to = bilhete.consultar(to);
		
		if(to != null){
		request.setAttribute("bilhete", to);
		RequestDispatcher view = request.getRequestDispatcher("TelaCheckinBilhete.jsp");
		view.forward(request, response);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("ErroCheckinBilhete.html");
			view.forward(request, response);
		}
		
		
	}

}
