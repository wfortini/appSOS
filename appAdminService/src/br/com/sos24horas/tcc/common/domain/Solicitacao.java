package br.com.sos24horas.tcc.common.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author wellington
 *
 */
@Entity
@Table(name="solicitacao")
public class Solicitacao implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_solicitacao")
	private Long idSolicitacao;
	
	@Column(name="latitude")
	private Integer latitude;
	
	@Column(name="longitude")
	private Integer longitute;
	
	@ManyToOne
	@JoinColumn(name="id_segurado")
	private Segurado segurado;
	
	@ManyToOne
	@JoinColumn(name="id_prestador")
	private Prestador prestador;
	
	@ManyToOne
	@JoinColumn(name="id_atendente")
	private Atendente atendente;
	
	@Column(name="dat_hora_inicio_solic")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSolicitacao;
	
	@Column(name="id_dispositivo")
	private String idDispositivo;
	
	@Column(name="local_disponivel")
	private Boolean localDisponivel;
	
	@Column(name="dat_hora_inic_atendimento")
	@Temporal(TemporalType.TIMESTAMP)
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
