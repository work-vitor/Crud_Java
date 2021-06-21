package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	/*
	*c: create
	*r: read
	*u: update
	*d: delete
	*/
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?, ?) ";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			
			//Cria uma conexeão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();//Chamando a conexão
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm =  (JdbcPreparedStatement) conn.prepareStatement(sql);

			//Adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Executar a query
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões
			try {
				
				if (pstm!=null) {
					pstm.close();
				}
				
				if (conn!=null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				
			}
		}
		
		
	}
	
	
}
