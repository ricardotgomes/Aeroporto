package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginModel;




/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		LoginModel verifica = new LoginModel();
		boolean login2 = verifica.analizarSenha(login, senha);
		
		if(login2 == true){
		RequestDispatcher view = request.getRequestDispatcher("index.html");
		view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("login.html");
			view.forward(request, response);
		}
	}

}
