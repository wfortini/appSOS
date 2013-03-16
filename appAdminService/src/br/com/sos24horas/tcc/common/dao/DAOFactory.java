package br.com.sos24horas.tcc.common.dao;

import br.com.sos24horas.tcc.atendimento.dao.AtendimentoDAO;
import br.com.sos24horas.tcc.atendimento.dao.AtendimentoDAOHibernate;
import br.com.sos24horas.tcc.common.conexao.HibernateUtil;
import br.com.sos24horas.tcc.solicitacao.dao.SolicitacaoDAO;
import br.com.sos24horas.tcc.solicitacao.dao.SolicitacaoDAOHibernate;

public class DAOFactory {

	public static SolicitacaoDAO criarSolicitacaoDAO(){
		SolicitacaoDAOHibernate dao = new SolicitacaoDAOHibernate();
		dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return dao;
	}
	
	public static AtendimentoDAO criarAtendimentoDAO(){
		AtendimentoDAOHibernate dao = new AtendimentoDAOHibernate();
		dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return dao;
	}
	

}
