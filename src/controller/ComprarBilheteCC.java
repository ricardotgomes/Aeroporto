	package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PagamentoCartaoCredito;
import to.PagamentoCartaoCreditoTO;
import factory.TOFactory;

/**
 * Servlet implementation class ComprarBilheteCC
 */
@WebServlet("/ComprarBilheteCC.do")
public class ComprarBilheteCC extends HttpServlet {
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
		String bandeira = request.getParameter("bandeira");
		String nomeTitular = request.getParameter("nomeTitular");
		int codSegurança = Integer.parseInt(request.getParameter("codSegurança"));
		String numeroCartao = request.getParameter("numeroCartao");		
		String dataVencimento = request.getParameter("dataVencimento");	
		
		PagamentoCartaoCredito pagamento = new PagamentoCartaoCredito();
		PagamentoCartaoCreditoTO pagamentoTO = TOFactory.getPagamentoCartaoCreditoTO();
		
		pagamentoTO.numeroBilhete = numeroBilhete;
		pagamentoTO.bandeira = bandeira;
		pagamentoTO.codigoSeguranca = codSegurança;
		pagamentoTO.cpf = cpf;
		pagamentoTO.nomeTitular = nomeTitular;
		pagamentoTO.numeroCartao = numeroCartao;
		pagamentoTO.dataVencimento = dataVencimento;
		
		
		
			
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
