package br.com.sos24horas.service.json.exception;

import java.io.Serializable;

/**
 * Classe base para todas as exceptions
 * @author wellington
 *
 */

public class BaseException extends Exception implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public BaseException(){
		super();
	}
	
	public BaseException(String message, Exception exception){
		super(message, exception);
	}
	
	public BaseException(String message){
		super(message);
	}

	public BaseException(Exception exception){
		super(exception);
	}
}
