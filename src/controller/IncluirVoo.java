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
 * Servlet implementation class IncluirVoo
 */
@WebServlet("/IncluirVoo.do")
public class IncluirVoo extends HttpServlet {
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
		
		int codAeronave = Integer.parseInt(request.getParameter("codAeronave"));
		int codVoo = Integer.parseInt(request.getParameter("codVoo"));
		int valorVoo = Integer.parseInt(request.getParameter("valorVoo"));
		String dataHora = request.getParameter("dataHora");
		String destino = request.getParameter("destino");
		String escala = request.getParameter("escala");
		String origem = request.getParameter("origem");
		
		VooMoldel voo = new VooMoldel();
		VooTO to = TOFactory.getVooTO();
		to.codAeronave = codAeronave;
		to.codVoo = codVoo;
		to.valorVoo = valorVoo;
		to.dataHora = dataHora;
		to.destino= destino;
		to.escala = escala;
		to.origem = origem;
		
		to = voo.incluir(to);
		
		if(to != null){
		request.setAttribute("voo", to);
		RequestDispatcher view = request.getRequestDispatcher("TelaVooIncluido.jsp");
		view.forward(request, response);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("ErroIncluirVoo.html");
			view.forward(request, response);
		}
	}

}
