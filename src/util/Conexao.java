package util;
//teste realizado com sucesso
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simoneConfeccoes", "postgres", "123456");
			System.out.println("Conectado com Sucesso");
		} catch (Exception e) {
			System.out.println("Erro de conexao com o banco de dados: "+e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
}
