package br.com.sos24horas.tcc.domain.solicitacao;

import java.io.Serializable;
import java.util.Date;

public class Solicitacao implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer latitude;
	private Integer longitute;
	private Long idCliente;
	private Date dataSolicitacao;
	private String registroGCM;
	
	
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
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getRegistroGCM() {
		return registroGCM;
	}
	public void setRegistroGCM(String registroGCM) {
		this.registroGCM = registroGCM;
	}
	
	
	

}
