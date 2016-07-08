package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PagamentoCartaoDebito;
import to.PagamentoCartaoDebitoTO;
import factory.TOFactory;

/**
 * Servlet implementation class EstornarPagamentoCD
 */
@WebServlet("/EstornarPagamentoCD.do")
public class EstornarPagamentoCD extends HttpServlet {
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
				
		PagamentoCartaoDebito pagamento = new PagamentoCartaoDebito();
		PagamentoCartaoDebitoTO to = TOFactory.getPagamentoCartaoDebitoTO();
		
		to.numeroBilhete = numeroBilhete;
		to.agencia= "";
		to.banco = "";
		to.cpf = "";
		to.nomeTitular = "";
		to.contaCorrente = "";
		to.telefone = "";
				
		to = pagamento.estornar(to);
		
		if(to != null){
		request.setAttribute("pagamento", to);
		RequestDispatcher view = request.getRequestDispatcher("TelaEstornarPagamentoCD.jsp");
		view.forward(request, response);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("ErroConexao.html");
			view.forward(request, response);
		}
		
	}

}
