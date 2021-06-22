package br.com.agenda.aplicacao;

import java.sql.SQLException;
import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ContatoDAO contatoDAO = new ContatoDAO();
		
		//Inserindo os dados no banco
		Contato contato = new Contato();
		contato.setNome("Paulo Vitor");
		contato.setIdade(18);
		contato.setDataCadastro(new Date());

		contatoDAO.save(contato);
		
		//Visualizando os registros do banco de dados
		
		for(Contato c : contatoDAO.getContatos()) {
			System.out.println("Contato: "+c.getNome());
		}
		
		
		

	}

}
