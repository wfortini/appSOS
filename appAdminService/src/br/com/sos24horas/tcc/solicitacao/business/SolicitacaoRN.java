package br.com.sos24horas.tcc.solicitacao.business;

import br.com.sos24horas.tcc.common.dao.DAOFactory;
import br.com.sos24horas.tcc.common.domain.Solicitacao;
import br.com.sos24horas.tcc.solicitacao.dao.SolicitacaoDAO;

public class SolicitacaoRN {
	
	private SolicitacaoDAO dao;
	
	public SolicitacaoRN() {
		this.dao = DAOFactory.criarSolicitacaoDAO();
	}
	
	public void incluirSolicitacao(Solicitacao solicitacao){
		this.dao.incluirSolicitacao(solicitacao);
	}
	
	
}
