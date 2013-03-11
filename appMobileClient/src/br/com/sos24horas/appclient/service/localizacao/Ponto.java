package br.com.sos24horas.appclient.service.localizacao;

import android.location.Location;

import com.google.android.maps.GeoPoint;



/**
 * classe falicita a utilização e conversão
 * de graus para microdegrees
 */

/**
 * 
 * @author wellington
 *
 */
public class Ponto extends GeoPoint{
	
	/**
	 * valor em graus * 1E6
	 * @param latitudeE6
	 * @param longitudeE6
	 */
	public Ponto(int latitudeE6, int longitudeE6){
		super(latitudeE6, longitudeE6);
	}

	/**
	 * converte para graus * 1E6
	 * @param latitude
	 * @param longitute
	 */
	public Ponto(double latitude, double longitute){
		this((int) (latitude*1E6), (int) (longitute*1E6));
	}
	
	public Ponto(Location local){
		
		this(local.getLatitude(), local.getLongitude());
	}
	
	@Override
	public String toString() {
		
		return "Localização: Latitude:" + super.getLatitudeE6() + "e Longitude: " + super.getLongitudeE6();
	}
}
