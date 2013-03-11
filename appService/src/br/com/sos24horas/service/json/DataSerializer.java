package br.com.sos24horas.service.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import br.com.sos24horas.tcc.domain.common.exception.JSONException;

public class DataSerializer {
	
	private static DataSerializer instance;
	
	private ObjectMapper objectMapper = null;
	
	private DataSerializer(){
		this.objectMapper = new ObjectMapper();
	}

	public static DataSerializer getInstance(){
		
		if(instance == null){
			instance = new DataSerializer();
		}
		
		return instance;
		
	}
	
	@SuppressWarnings("deprecation")
	public String toJson(Object content) throws IOException{
		
		objectMapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
		return objectMapper.writeValueAsString(content);
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T toObject(String json, Class targetClass) throws IOException, JSONException{		
		try {
			return (T) objectMapper.readValue(json, targetClass);
		} catch (JsonParseException e) {
			throw new JSONException(e);
		}catch(JsonMappingException je){
			throw new JSONException(je);
		}
		
		
	}
}
