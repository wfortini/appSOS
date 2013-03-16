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
@Table(name="seguro_segurado")
public class SeguroSegurado implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_seguro_segurado")
	private Long idSeguroSegurado;
	
	@ManyToOne
	@JoinColumn(name="id_seguro")
	private Seguro seguro;
	
	@ManyToOne
	@JoinColumn(name="id_segurado")
	private Segurado segurado;
	
	@Column(name="dat_inicio_vigencia")
	@Temporal(TemporalType.DATE)
	private Date dataInicioVigencia;
	

	@Column(name="dat_fim_vigencia")
	@Temporal(TemporalType.DATE)
	private Date dataFimVigencia;
	
	public SeguroSegurado() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdSeguroSegurado() {
		return idSeguroSegurado;
	}

	public void setIdSeguroSegurado(Long idSeguroSegurado) {
		this.idSeguroSegurado = idSeguroSegurado;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}


	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idSeguroSegurado == null) ? 0 : idSeguroSegurado.hashCode());
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
		SeguroSegurado other = (SeguroSegurado) obj;
		if (idSeguroSegurado == null) {
			if (other.idSeguroSegurado != null)
				return false;
		} else if (!idSeguroSegurado.equals(other.idSeguroSegurado))
			return false;
		return true;
	}
	
	

}
