package br.com.sos24horas.tcc.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author wellington
 *
 */
@Entity
@Table(name="seguro")
public class Seguro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_seguro")
	private Long idSeguro;
	
	private String descricao;
	
	@OneToMany(mappedBy="seguro", cascade=CascadeType.ALL)
	private List<SeguroSegurado> seguroSegurados = new ArrayList<SeguroSegurado>();
	
	public Seguro() {
		// TODO Auto-generated constructor stub
	}
	
		
	public List<SeguroSegurado> getSeguroSegurados() {
		return seguroSegurados;
	}




	public void setSeguroSegurados(List<SeguroSegurado> seguroSegurados) {
		this.seguroSegurados = seguroSegurados;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSeguro == null) ? 0 : idSeguro.hashCode());
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
		Seguro other = (Seguro) obj;
		if (idSeguro == null) {
			if (other.idSeguro != null)
				return false;
		} else if (!idSeguro.equals(other.idSeguro))
			return false;
		return true;
	}



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
