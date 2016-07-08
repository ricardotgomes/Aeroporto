package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Passageiro;
import to.PassageiroTO;
import factory.TOFactory;

/**
 * Servlet implementation class AlterarPassageiro
 */
@WebServlet("/AlterarPassageiro.do")
public class AlterarPassageiro extends HttpServlet {
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
		
		String cpf = request.getParameter("cpf");
		String nomePassageiro = request.getParameter("nomePassageiro");
		String sobrenomePassageiro = request.getParameter("sobrenomePassageiro");
		String email = request.getParameter("email");
		String endereço = request.getParameter("endereço");	
		String telefone = request.getParameter("telefone");	
		String titulo = request.getParameter("titulo");	
		
		Passageiro passageiro = new Passageiro();
		PassageiroTO to = TOFactory.getPassageiroTO();
		to.cpf = cpf;
		to.nome = nomePassageiro;
		to.sobrenome = sobrenomePassageiro;
		to.email = email;
		to.endereco = endereço;
		to.telefone = telefone;
		to.titulo = titulo;
		
		to = passageiro.alterar(to);
		
		if(to != null){
			request.setAttribute("passageiro", to);
			RequestDispatcher view = request.getRequestDispatcher("TelaPassageiroAlterado.jsp");
			view.forward(request, response);
			}else {
				RequestDispatcher view = request.getRequestDispatcher("ErroConexao.html");
				view.forward(request, response);
				
			}
		
		
	}

}
