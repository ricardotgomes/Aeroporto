package model;


import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;

public class LoginModel {

	private boolean cont;
	private Scanner scanner;

	public LoginModel() {
		cont = false;
	}

	public boolean analizarSenha(String log, String sen) {

		try {

			InputStream teclado = new FileInputStream(
					"C:/Users/Ricardo/workspace/venda_de_passagens/clients.txt");
			scanner = new Scanner(teclado);
			Scanner scanner2 = scanner.useDelimiter(";");

			while (scanner2.hasNext()) {
				String validaLogin, validaSenha;

				validaLogin = scanner2.next();
				validaSenha = scanner2.next();

				if (validaSenha.equals(sen) && validaLogin.equals(log)) {

					cont = true;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return cont;
	}
}