package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	
	public BancoDados() {
		this.url = "jdbc:postgresql://localhost:5432/socket";  // link do banco de dados no local host
		this.usuario = "postgres";  // usuario
		this.senha = "358899500";  // senha
		
		try {
		//	Class.forName("org.postgresql.Driver");  // chama o driver da biblioteca jdbc 
			this.con = DriverManager.getConnection(url, usuario, senha); // tenta conex�o com o bd passando a url o usuario e senha informada
			System.out.println("Conex�o realizada com sucesso ao banco de dados!!"); // se tiver tudo correto realiza a conex�o
		} catch (SQLException e) {
			e.printStackTrace(); // se der erro na conex�o retorna erro
		}
		
	}
	
	public void guardaMsg(String sql) {
		
		try {
			// recebe um parametro String sql e envia para o banco
			Statement stm = con.createStatement();   
			stm.executeUpdate(sql);
			// se enviar com sucesso retorna 1 para positivo
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
