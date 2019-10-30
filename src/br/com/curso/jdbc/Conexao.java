package br.com.curso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres", "postgres");
			System.out.println("Conexão realizado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("A conexão falhou!!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado!!");
			e.printStackTrace();
		}
		return con;
	}
	
}
