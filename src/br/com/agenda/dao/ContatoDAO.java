package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	/*
	 * c: create r: read u: update d: delete
	 */

	public void save(Contato contato) {

		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?, ?) ";

		Connection conn = null;
		JdbcPreparedStatement pstm = null;

		try {

			// Cria uma conexeão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();// Chamando a conexão

			// Criamos uma PreparedStatement, para executar uma query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);

			// Adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// Executar a query
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fechar as conexões
			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();

			}
		}

	}

	public void update(Contato contato) throws Exception {

		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? " + "WHERE id = ?";

		Connection conn = null;
		JdbcPreparedStatement pstm = null;

		try {

			// Crair a conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			// Criar a classe para executar a query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);

			// Adicionar os valores de update
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// ID do usuario que será atualizado
			pstm.setInt(4, contato.getId());

			// executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null && conn != null) {
					pstm.close();
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	public List<Contato> getContatos() throws SQLException {

		String sql = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<Contato>();

		Connection conn = null;

		JdbcPreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco. """"SELECT"""
		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Contato contato = new Contato();

				// Capturar o ID
				contato.setId(rset.getInt("id"));
				// Capturar o nomme
				contato.setNome(rset.getString("nome"));
				// Capturar a idade
				contato.setIdade(rset.getInt("idade"));
				// Recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("dataCadastro"));

				contatos.add(contato);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return contatos;

	}

}
