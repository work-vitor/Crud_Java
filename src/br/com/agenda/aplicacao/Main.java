package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ContatoDAO contatoDAO = new ContatoDAO();
		
		//Inserindo os dados no banco
		Contato contato = new Contato();
		contato.setNome("Paulo Vitor");
		contato.setIdade(18);
		contato.setDataCadastro(new Date());

		//contatoDAO.save(contato);
		
		//Atualizar o contato
		Contato c1 = new Contato();
		c1.setNome("João vitor costa");
		c1.setIdade(19);
		c1.setDataCadastro(new Date());
		c1.setId(1);
		
		contatoDAO.update(c1);
		
		//Visualizando os registros do banco de dados
		System.out.println("Nome       | Idade  | Data de Cadastro");
		for(Contato c : contatoDAO.getContatos()) {
			System.out.print(c.getNome());
			System.out.print("|    "+c.getIdade());
			System.out.print("    |"+c.getDataCadastro());
			
			System.out.println();
			
		}
		
		
		

	}

}
