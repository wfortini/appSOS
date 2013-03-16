package br.com.sos24horas.tcc.atendimento.business;

import br.com.sos24horas.tcc.atendimento.dao.AtendimentoDAO;
import br.com.sos24horas.tcc.common.dao.DAOFactory;
import br.com.sos24horas.tcc.common.domain.Atendimento;
import br.com.sos24horas.tcc.common.domain.Solicitacao;

public class AtendimentoRN {
	
private AtendimentoDAO dao;
	
	public AtendimentoRN() {
		this.dao = DAOFactory.criarAtendimentoDAO();
	}
	
	public void incluirAtendimento(Solicitacao solicitacao){
		Atendimento at = new Atendimento(solicitacao);
		this.dao.incluirAtendimento(at);
	}

}
