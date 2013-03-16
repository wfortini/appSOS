package br.com.sos24horas.tcc.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author wellington
 *
 */
@Entity
@Table(name="atendente")
public class Atendente implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_atendente")
	private Long idAtendente;
	
	@Column(name="nome_atendente")
	private String nome;
	
	@Column(name="dat_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	/** Um para Muitos **/
	@OneToMany(mappedBy="atendente", cascade=CascadeType.ALL)
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	
	/** mapeamento tabela Atendimento e atendente **/
	@OneToMany(mappedBy="atendente", cascade=CascadeType.ALL)
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();

	public Atendente() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdAtendente() {
		return idAtendente;
	}

	public void setIdAtendente(Long idAtendente) {
		this.idAtendente = idAtendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}	
	

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAtendente == null) ? 0 : idAtendente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendente other = (Atendente) obj;
		if (idAtendente == null) {
			if (other.idAtendente != null)
				return false;
		} else if (!idAtendente.equals(other.idAtendente))
			return false;
		return true;
	}
	
	

}
