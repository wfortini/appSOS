package br.com.sos24horas.appclient.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author wellington
 *
 */

public class Solicitacao implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long idSolicitacao;
	
	
	private Integer latitude;	
	private Integer longitute;	
	private Segurado segurado;	
	private Prestador prestador;	
	private Atendente atendente;	
	private Date dataSolicitacao;
	private String idDispositivo;	
	private Boolean localDisponivel;	
	private Date dataHoraInicioAtendimento;
	
	public Solicitacao() {
		// TODO Auto-generated constructor stub
	}

	
	public Date getDataHoraInicioAtendimento() {
		return dataHoraInicioAtendimento;
	}


	public void setDataHoraInicioAtendimento(Date dataHoraInicioAtendimento) {
		this.dataHoraInicioAtendimento = dataHoraInicioAtendimento;
	}


	public Long getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(Long idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitute() {
		return longitute;
	}

	public void setLongitute(Integer longitute) {
		this.longitute = longitute;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public Boolean getLocalDisponivel() {
		return localDisponivel;
	}

	public void setLocalDisponivel(Boolean localDisponivel) {
		this.localDisponivel = localDisponivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSolicitacao == null) ? 0 : idSolicitacao.hashCode());
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
		Solicitacao other = (Solicitacao) obj;
		if (idSolicitacao == null) {
			if (other.idSolicitacao != null)
				return false;
		} else if (!idSolicitacao.equals(other.idSolicitacao))
			return false;
		return true;
	}
	
	
	 
	
	
	
	

}
