package br.edu.ifsp.arq.arqweb1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public RegisterServlet() {
		super();
	}

	// doGet + ctrl + espaço
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String[] options = request.getParameterValues("options");
		String selectedOptions = "";
		for(String opt: options) {
			selectedOptions += opt + " ";
		}
		// gerar a resposta
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("\t<meta charset=\"UTF-8\" >");
		writer.println("\t<title>Página de Resposta - Register App</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("\t<h1>Cadastro realizado com sucesso!</h1>");
		writer.println("\t<h2>Nome Completo: " + fullName + "</h2>");
		writer.println("\t<h2>Email: " + email + "</h2>");
		writer.println("\t<h2>Interesses: " + selectedOptions + "</h2>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
