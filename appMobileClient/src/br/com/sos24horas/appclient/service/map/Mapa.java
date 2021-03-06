package br.com.sos24horas.appclient.service.map;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import br.com.sos24horas.appclient.R;
import br.com.sos24horas.appclient.service.localizacao.Localizacao;
import br.com.sos24horas.appclient.service.localizacao.Ponto;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class Mapa extends MapActivity{
	
	private static final String TAG = "MAPA";
	private MapController controle;
	private MapView mapa;
	
	
	@Override
	protected void onCreate(Bundle icicle) {
		
		super.onCreate(icicle);
		setContentView(R.layout.mapview);
		mapa = (MapView) findViewById(R.id.mapa);
		mapa.setClickable(true);
		mapa.setStreetView(true);
		controle = mapa.getController();
		controle.setZoom(16);
		
		Localizacao local = new Localizacao(getSystemService(Context.LOCATION_SERVICE));
	    Ponto ponto = local.getUltimaLocalizacao();		    
	   
	   Log.d(TAG, "Localização  " + ponto);
	   
	   controle.setCenter(ponto);
	   controle.animateTo(ponto);
	   mapa.invalidate();
		
	}
	
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
