package br.com.sos24horas.appclient.http;

import br.com.sos24horas.appclient.service.http.client.WebService;


public class ServicoWeb implements Runnable{
	
	private String serveName;
	private String json;
	private String response;	
	

	@Override
	public void run() {
		
		WebService web = new WebService(this.serveName);
		response = web.webInvoke("", this.json);
		
		
	}
	
	public String getResponse() {
		return response;
	}




	public void setResponse(String response) {
		this.response = response;
	}




	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public ServicoWeb() {
		
	}
	
	public ServicoWeb(String serveName) {
	    this.serveName = serveName;

	}
	
	

}
