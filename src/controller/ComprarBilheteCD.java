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
 * Servlet implementation class ComprarBilheteCD
 */
@WebServlet("/ComprarBilheteCD.do")
public class ComprarBilheteCD extends HttpServlet {
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
		String cpf = request.getParameter("cpf");
		String nomeTitular = request.getParameter("nomeTitular");
		String agencia = request.getParameter("agencia");
		String telefone = request.getParameter("telefone");
		String contaCorrente = request.getParameter("contaCorrente");
		String banco = request.getParameter("banco");
		
		PagamentoCartaoDebito pagamento = new PagamentoCartaoDebito();
		PagamentoCartaoDebitoTO pagamentoTO = TOFactory.getPagamentoCartaoDebitoTO();
		
		
		pagamentoTO.telefone = telefone;
		pagamentoTO.numeroBilhete = numeroBilhete;
		pagamentoTO.cpf = cpf;
		pagamentoTO.nomeTitular = nomeTitular;
		pagamentoTO.agencia = agencia;
		pagamentoTO.banco = banco;
		pagamentoTO.contaCorrente = contaCorrente;
		
		
		 	pagamentoTO = pagamento.incluir(pagamentoTO);
		 	
		 	if(pagamentoTO != null){
			request.setAttribute("pagamento", pagamentoTO);
			RequestDispatcher view = request.getRequestDispatcher("TelaPagamentoRealizado.jsp");
			view.forward(request, response);
			
		 	} else {
		 		RequestDispatcher view = request.getRequestDispatcher("ErroConexao.html");
				view.forward(request, response);
		 	}
		
		
	}

}
