package br.com.sos24horas.appclient.domain;

import java.io.Serializable;
import java.util.Date;


public class Segurado implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long idSegurado;	
	private String nome;	
	private Date dataCadastro;	
	private String cpfCNPJ;	
	private String celular;	
	private String dispositivo;	
	
	public Segurado() {
		// TODO Auto-generated constructor stub
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

	
	
    
	

}
