package br.com.sos24horas.service.json.exception;

/**
 * Encapsula exception da api json
 * @author wellington
 *
 */
public class JSONException extends BaseException{

	
	private static final long serialVersionUID = 1L;
	
	public JSONException() {
		
	}	

	public JSONException(String message, Exception exception){
		super(message, exception);
	}
	
	public JSONException(String message){
		super(message);
	}

	public JSONException(Exception exception){
		super(exception);
	}
	
	

}
