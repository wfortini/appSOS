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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="segurado")
public class Segurado implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_segurado")
	private Long idSegurado;
	
	@Column(name="nome_cliente")
	private String nome;
	
	@Column(name="dat_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Column(name="CPFCNPJ")
	private String cpfCNPJ;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="dispositivo")
	private String dispositivo;
	
	/** Um segurado pode ter muitos atendimentos **/
	@OneToMany(mappedBy="segurado", cascade=CascadeType.ALL)
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	/** Um segurado pode ter muitas solicitações **/
	@OneToMany(mappedBy="segurado", cascade=CascadeType.ALL)
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	
	/** Um segurado pode ter muitos veiculos **/
	@OneToMany(mappedBy="segurado", cascade=CascadeType.ALL)
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	
	public Segurado() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}



	public Long getIdSegurado() {
		return idSegurado;
	}
	public void setIdSegurado(Long idSegurado) {
		this.idSegurado = idSegurado;
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
	public String getCpfCNPJ() {
		return cpfCNPJ;
	}
	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	
	
    
	

}
