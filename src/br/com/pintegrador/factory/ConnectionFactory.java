package br.com.pintegrador.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//NOME DO USUÁRIO DO POSTGRES
	private static final String USERNAME = "postgres";
	
	//SENHA DO BANCO
	private static final String PASSWORD = "Devc7w4@";
	
	//CAMINHO DO BANCO DE DADOS,PORTA E NOME DO BANCO
	
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/Projeto Integrador";
	
	//CONEXÃO COM O BANCO DE DADOS
	public static Connection createConnectionToPostgresSQL() throws Exception {
		//FAZ COM QUE A CLASSE SEJA CARREGADA PELA JVM
		Class.forName("org.postgresql.Driver");
		
		//CRIA A CONEXÃO COM O BANCO DE DADOS
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		//RECUPERAR UMA CONEXÃO COM O BANCO DE DADOS
		Connection con = createConnectionToPostgresSQL();
				
		con.close();
		System.out.println("conexão obtida com sucesso!");
					
	}
}
