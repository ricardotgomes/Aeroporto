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
 * Servlet implementation class ExcluirPassageiro
 */
@WebServlet("/ExcluirPassageiro.do")
public class ExcluirPassageiro extends HttpServlet {
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
		
		Passageiro passageiro = new Passageiro();
		PassageiroTO to = TOFactory.getPassageiroTO();
		to.cpf = cpf;
		to.nome = "";
		to.sobrenome = "";
		to.email = "";
		to.endereco = "";
		to.telefone = "";
		to.titulo = "";
		
		to = passageiro.excluir(to);
		
		if(to != null){
		request.setAttribute("passageiro", to);
		RequestDispatcher view = request.getRequestDispatcher("TelaPassageiroExcluido.jsp");
		view.forward(request, response);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("ErroExcluirPassageiro.html");
			view.forward(request, response);
		}
	}

}
