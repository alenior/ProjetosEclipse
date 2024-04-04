package academico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/consultaAluno")
public class ConsultaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Obtendo o parâmetro de matrícula do aluno
		int matricula = Integer.parseInt(request.getParameter("matricula"));

		try (
				// Estabelecendo conexão com o banco de dados
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alunos WHERE matricula = ?");) {
			stmt.setInt(1, matricula);

			// Executando a consulta SQL
			ResultSet rs = stmt.executeQuery();

			out.println("<!DOCTYPE html>");
			out.println("<html lang = 'pt-br'>");
			out.println("<head>");
			out.println("<title>Detalhes do Aluno</title>");
			out.println("<link rel=\"icon\" href=\"imagens/favicon.png\">");
			out.println("<link rel=\"stylesheet\" href=\"style.css\">");
			out.println("</head>");
			out.println("<body>");

			if (rs.next()) {
				// Se o aluno for encontrado, exibe seus detalhes
				out.println("<div>");
				out.println("<h1>Detalhes do Aluno</h1>");
				out.println("<img alt=\"Imagem de pesquisar\" src=\"imagens/pesquisar.png\">");
				out.println("<p>Matrícula: " + rs.getInt("matricula") + "</p>");
				out.println("<p>Nome: " + rs.getString("nome") + "</p>");
				out.println("<p>Média: " + rs.getDouble("media") + "</p>");
				out.println("<p>Frequência: " + rs.getDouble("frequencia") + "</p>");
				out.println("</div>");
				out.println("<a href = \"index.html\" class = \"Botao1\" >Voltar</a>");
			} else {
				// Se o aluno não for encontrado, exibe uma mensagem de erro
				out.println("<div>");
				out.println("<h1>Aluno não encontrado</h1>");
				out.println("<img alt=\"Imagem de não econtrado\" src=\"imagens/nao_encontrado.png\">");
				out.println("</div>");
				out.println("<a href = \"index.html\" class = \"Botao1\" >Voltar</a>");
			}

			out.println("</body>");
			out.println("</html>");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("<h2>Ocorreu um erro ao consultar o banco de dados</h2>");
		}
	}
}