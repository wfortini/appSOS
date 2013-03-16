package br.com.sos24horas.appclient.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author wellington
 *
 */

public class Atendente implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Long idAtendente;	
	private String nome;	
	private Date dataCadastro;	
	

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
