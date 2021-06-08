package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuario mysql
	private static final String USERNAME = "root";
	//Senha do banco
	private static final String PASSWORD = "123456";
	//Caminho do banco dde daaos
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	//Conexao com o banco de dados
	
	public static Connection createConnectionToMySQL() throws Exception{
		//Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception{
		
		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexao é nula
		if (con!=null) {
			System.out.println("Conexão obetida com sucesso!");
			con.close();
		}
		
	}
	
	
}
