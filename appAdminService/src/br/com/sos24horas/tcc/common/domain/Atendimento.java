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
@Table(name="atendimento")
public class Atendimento implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	@Column(name="id_atendimento")
	private Long idAtendimento;
	
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
	
	@Column(name="dat_hora_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicioAtendimento;
	
	@Column(name="dat_hora_fim")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFimAtendimento;
	
	@Column(name="id_dispositivo")
	private String idDispositivo;
	
	@Column(name="local_disponivel")
	private Boolean localDisponivel;

	public Atendimento() {
		// TODO Auto-generated constructor stub
	}
	
	public Atendimento(Solicitacao solicitacao){
		
		this.latitude = solicitacao.getLatitude();
		this.longitute = solicitacao.getLongitute();
		this.atendente = solicitacao.getAtendente();
		this.segurado = solicitacao.getSegurado();
		this.localDisponivel = solicitacao.getLocalDisponivel();
		this.dataInicioAtendimento = solicitacao.getDataHoraInicioAtendimento();
		this.prestador = solicitacao.getPrestador();
		this.idDispositivo = solicitacao.getIdDispositivo();
		
	}

	public Long getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Long idAtendimento) {
		this.idAtendimento = idAtendimento;
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

	public Date getDataInicioAtendimento() {
		return dataInicioAtendimento;
	}

	public void setDataInicioAtendimento(Date dataInicioAtendimento) {
		this.dataInicioAtendimento = dataInicioAtendimento;
	}

	public Date getDataFimAtendimento() {
		return dataFimAtendimento;
	}

	public void setDataFimAtendimento(Date dataFimAtendimento) {
		this.dataFimAtendimento = dataFimAtendimento;
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
				+ ((idAtendimento == null) ? 0 : idAtendimento.hashCode());
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
		Atendimento other = (Atendimento) obj;
		if (idAtendimento == null) {
			if (other.idAtendimento != null)
				return false;
		} else if (!idAtendimento.equals(other.idAtendimento))
			return false;
		return true;
	}
	
	
}
