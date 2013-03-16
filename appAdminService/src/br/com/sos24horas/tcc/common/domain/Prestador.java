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
@Table(name="prestador")
public class Prestador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_prestador")
	private Long igPrestador;
	
	@Column(name="nome_prestador")
	private String nome;
	
	@Column(name="CPFCNPJ")
	private String cpfCNPJ;
	
	private String funcao;
	
	@Column(name="dat_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	/** Um PRESTADOR pode ter muitos atendimentos **/
	@OneToMany(mappedBy="segurado", cascade=CascadeType.ALL)
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	/** Um PRESTADOR pode ter muitas solicitações **/
	@OneToMany(mappedBy="segurado", cascade=CascadeType.ALL)
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	
	public Prestador() {
		// TODO Auto-generated constructor stub
	}

	public Long getIgPrestador() {
		return igPrestador;
	}

	public void setIgPrestador(Long igPrestador) {
		this.igPrestador = igPrestador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCNPJ() {
		return cpfCNPJ;
	}

	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((igPrestador == null) ? 0 : igPrestador.hashCode());
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
		Prestador other = (Prestador) obj;
		if (igPrestador == null) {
			if (other.igPrestador != null)
				return false;
		} else if (!igPrestador.equals(other.igPrestador))
			return false;
		return true;
	}
	
	
	
	
	
	

}
