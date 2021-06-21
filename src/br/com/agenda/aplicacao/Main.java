package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("João Vitor");
		contato.setIdade(55);
		contato.setDataCadastro(new Date());
		
		contatoDAO.save(contato);

	}

}
