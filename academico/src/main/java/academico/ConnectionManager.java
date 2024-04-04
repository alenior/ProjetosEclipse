package academico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/dbacademico?useTimezone=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    
    public static Connection getConnection() throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}