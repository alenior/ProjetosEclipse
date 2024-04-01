package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.DAO;
import model.JavaBeans;

@WebServlet(name = "controller", urlPatterns = {"/controller", "/main", "/insert"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
       
    public Controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if(action.equals("/insert")) {
			novoContato(request, response);
		}
		/**Teste de conexão.
		dao.testeConexao();**/
	}
	
	//Listar contatos.
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
	}
	
	//Novo contato.
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**teste de recebimento de dados do formulário.
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));*/
		//setar as variáveis JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		// invocar o método inserirContato passando o objeto contato.
		dao.inserirContato(contato);
		// Redirecionar para o documento agenda.jsp.
		response.sendRedirect("main");
	}

}
