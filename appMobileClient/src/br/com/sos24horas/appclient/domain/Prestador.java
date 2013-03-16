package br.com.sos24horas.appclient.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author wellington
 *
 */

public class Prestador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long igPrestador;	
	private String nome;	
	private String cpfCNPJ;	
	private String funcao;	
	private Date dataCadastro;		
	
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
