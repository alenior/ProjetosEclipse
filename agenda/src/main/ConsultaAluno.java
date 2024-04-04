package academico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
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

		class ConnectionManager {
			private static final String URL = "jdbc:mysql://127.0.0.1:3306/dbacademico?useTimezone=true&serverTimezone=UTC";
			private static final String USERNAME = "root";
			private static final String PASSWORD = "password";

			public static Connection getConnection() throws SQLException {
				return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		}

		try (
				// Estabelecendo conexão com o banco de dados
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alunos WHERE matricula = ?");) {
			stmt.setInt(1, matricula);

			// Executando a consulta SQL
			ResultSet rs = stmt.executeQuery();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Detalhes do Aluno</title>");
			out.println("</head>");
			out.println("<body>");

			if (rs.next()) {
				// Se o aluno for encontrado, exibe seus detalhes
				out.println("<h2>Detalhes do Aluno</h2>");
				out.println("<p>Matrícula: " + rs.getInt("matricula") + "</p>");
				out.println("<p>Nome: " + rs.getString("nome") + "</p>");
				out.println("<p>Média: " + rs.getDouble("media") + "</p>");
				out.println("<p>Frequência: " + rs.getDouble("frequencia") + "</p>");
			} else {
				// Se o aluno não for encontrado, exibe uma mensagem de erro
				out.println("<h2>Aluno não encontrado</h2>");
			}

			out.println("</body>");
			out.println("</html>");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("<h2>Ocorreu um erro ao consultar o banco de dados</h2>");
		}
	}
}
