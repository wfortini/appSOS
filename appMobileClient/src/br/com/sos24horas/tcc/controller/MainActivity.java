package br.com.sos24horas.tcc.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.sos24horas.appclient.R;
import br.com.sos24horas.appclient.service.localizacao.Localizacao;
import br.com.sos24horas.appclient.service.localizacao.Ponto;
import br.com.sos24horas.appclient.service.map.Mapa;
import br.com.sos24horas.service.json.DataSerializer;
import br.com.sos24horas.tcc.domain.solicitacao.Solicitacao;
import br.com.sos24horas.tcc.http.ServicoWeb;


public class MainActivity extends Activity implements LocationListener{
	
	private ProgressDialog dialog = null;
	private Ponto novoPonto;
	
	String serveName = "http://192.168.0.101:8080/appAdminService/solicitacao";
	
	private static final String TAG = "GCMActivity ";	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(listener);
		Button btnSuaLocal = (Button) findViewById(R.id.btnSuaLocal);
		btnSuaLocal.setOnClickListener(listenerSua);
		
	}
	
	private OnClickListener listenerSua = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent it = new Intent(MainActivity.this, Mapa.class);
			startActivity(it);
			
		}
	};
	
	
	private OnClickListener listener = new OnClickListener() {
		
		  
		
		@Override
		public void onClick(View v) {	
			
			dialog = ProgressDialog.show(MainActivity.this, "Comunicando", "Aguarde...", false, true);
			
		    Solicitacao solicitacao = new Solicitacao();		   
		    
		    Localizacao local = new Localizacao(getSystemService(Context.LOCATION_SERVICE));
		    Ponto ponto = local.getUltimaLocalizacao();		    
		   
		   Log.d(TAG, "Localização  " + ponto);
			    
		   solicitacao.setLatitude(ponto.getLatitudeE6());
		   solicitacao.setLongitute(ponto.getLongitudeE6());		    
			
		  
			
			try {
				
				ServicoWeb servico = new ServicoWeb(serveName);
				servico.setJson(DataSerializer.getInstance().toJson(solicitacao));
				new Thread(servico).start();
							
				
			} catch (Exception e) {
				Log.e(TAG, "Erro comunicacao " + e);
			}finally{
				dialog.dismiss();
			}
			
			
		}
	};
	
	public void onDestroy() {
		 
	     super.onDestroy();	
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	
	/** ...................................................................... **/
	@Override
	public void onLocationChanged(Location location) {
		 
		this.novoPonto = new Ponto(location);
		Log.d(TAG, "Nova localizaçãp " + location.getLatitude() + ", " + location.getLongitude());
		
	}
	
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}