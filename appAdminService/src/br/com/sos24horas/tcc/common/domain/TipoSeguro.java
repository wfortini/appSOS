package br.com.sos24horas.tcc.common.domain;

import java.io.Serializable;

public class TipoSeguro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idSeguro;
	private String descricao;
	public Long getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(Long idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
