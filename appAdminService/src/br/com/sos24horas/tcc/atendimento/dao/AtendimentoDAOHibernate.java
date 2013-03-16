package br.com.sos24horas.tcc.atendimento.dao;

import org.hibernate.Session;

import br.com.sos24horas.tcc.common.domain.Atendente;
import br.com.sos24horas.tcc.common.domain.Atendimento;

public class AtendimentoDAOHibernate implements AtendimentoDAO{

private Session sessao;
	
	public void setSession(Session sessao){
		this.sessao = sessao;
	}
	
	@Override
	public void incluirAtendimento(Atendimento atendimento) {
		this.sessao.persist(atendimento);
		
	}
}
