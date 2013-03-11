package br.com.sos24horas.appclient.service.localizacao;

import br.com.sos24horas.appclient.common.exception.LocalizacaoIndisponivelException;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * 
 * @author wellington
 *
 */
public class Localizacao implements LocationListener{
	
	public Localizacao() {
		// TODO Auto-generated constructor stub
	}	
	
	private LocationManager locationManager;
	private Context context;
	private Ponto pontoAtual;
	
	public Localizacao(Object service){
		if(service instanceof LocationManager){
			this.locationManager = (LocationManager) service;
		}else{
			throw new IllegalArgumentException("Erro - Object esperado LocationManager");
		}
	}
	
	public Localizacao(Object service, Context context){
		this(service);
		this.context = context;
	}
	
	/**
	 * Busca o melhor provedor de localização
	 * baseado nos criterios pré estabelecidos
	 * @return string provider
	 */
	public String getProvider(){		
		
		Criteria criteria = new Criteria () ;
	    criteria.setAccuracy ( Criteria.ACCURACY_FINE ) ;
	    criteria.setAltitudeRequired ( false ) ;
	    criteria.setBearingRequired ( false ) ;
	    criteria.setCostAllowed ( true ) ;
	    criteria.setPowerRequirement ( Criteria.POWER_LOW ) ;
	    String provider = this.locationManager.getBestProvider ( criteria, true ) ;
	    return provider;
	}
	
	/**
	 * retorno o ultimo ponto (Localização) conhecida
	 * @return
	 */
	public  Ponto getUltimaLocalizacao() throws LocalizacaoIndisponivelException{
		
		Location local = this.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER); //TODO: apos teste trocar por getProvider
		if(local != null){
			return new Ponto(local);
		}else{
			this.atualizarLocalizacao();
			if(this.pontoAtual != null && this.pontoAtual.getLatitudeE6() != 0){
				return this.pontoAtual;
			}else{
				throw new LocalizacaoIndisponivelException("Não foi possivél obter sua localização");
			}
		}
		
	}
	
	public void atualizarLocalizacao(){
		
		this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		
	}
	
	
	@Override
	public void onLocationChanged(Location location) {
		
		this.pontoAtual = new Ponto(location.getLatitude(), location.getLongitude());
		
	}
	
	public LocationManager getLocationManager(){
		return this.locationManager;
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

	public Ponto getPontoAtual() {
		return pontoAtual;
	}
	

}
