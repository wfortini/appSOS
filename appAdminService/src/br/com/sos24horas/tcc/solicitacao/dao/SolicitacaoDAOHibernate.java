package br.com.sos24horas.tcc.solicitacao.dao;

import org.hibernate.Session;

import br.com.sos24horas.tcc.common.domain.Solicitacao;

public class SolicitacaoDAOHibernate implements SolicitacaoDAO{
	
	private Session sessao;
	
	public void setSession(Session sessao){
		this.sessao = sessao;
	}
	
	@Override
	public void incluirSolicitacao(Solicitacao solicitacao) {
		this.sessao.persist(solicitacao);
		
	}

}
