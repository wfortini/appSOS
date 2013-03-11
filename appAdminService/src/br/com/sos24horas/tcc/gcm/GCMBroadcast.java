package br.com.sos24horas.tcc.gcm;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

public class GCMBroadcast {
	
	private String SENDER_ID = "AIzaSyB5i8wHc2EaRehgBy98hKV3DlTcJ5UEQYE";
	private String collapKey;
	private String message;
	private List<String> listaIdAndroids = new ArrayList<String>();
	private Sender sender;
	
	public GCMBroadcast() {
		// TODO Auto-generated constructor stub
	}
	
	public void send(){
		
		this.sender = new Sender(SENDER_ID);
		
		Message message = new Message.Builder()
		.collapseKey(this.collapKey)
		.timeToLive(30)
		.delayWhileIdle(true)
		.addData("message", this.message)
		.build();
		
		try {
			MulticastResult result = this.sender.send(message, this.listaIdAndroids, 1);
			if(result.getResults() != null){
				int regId = result.getCanonicalIds();
				if(regId != 0){
			}
        } else {
            int error = result.getFailure();
            System.out.println("Broadcast failure ======================: " + error);
        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public String getCollapKey() {
		return collapKey;
	}

	public void setCollapKey(String collapKey) {
		this.collapKey = collapKey;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	public boolean addIdAndroid(String id){
		return this.listaIdAndroids.add(id);
	}
	
}
