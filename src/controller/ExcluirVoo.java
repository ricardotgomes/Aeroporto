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
 * Servlet implementation class ExcluirVoo
 */
@WebServlet("/ExcluirVoo.do")
public class ExcluirVoo extends HttpServlet {
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
		
		to = voo.excluir(to);
		
		request.setAttribute("voo", to);
		RequestDispatcher view = request.getRequestDispatcher("TelaVooExcluido.jsp");
		view.forward(request, response);
	}

}
