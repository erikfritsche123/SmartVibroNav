package de.ur.erik.smartvibronav;

import org.haptimap.hcimodules.tactilecompass.TactileCompass;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;


public class KompassActivity extends Activity {
	
	static String route;

	private TactileCompass		tactileCompass;
	
	private Experiment			experiment;
	
	private static final String	TAG	= "KompassActivity";
	
	private double		LAT;
	private double		LON;

	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kompass);
		
		experiment = new Experiment();
		
		receiveUserData();
		
		
		final Location testLocation = createTestLocation();
		
		
		
		this.tactileCompass = new TactileCompass(this);
		this.tactileCompass.setDestination(testLocation);
	}

	private void receiveUserData() {
		Intent i = getIntent();
        route = i.getStringExtra("Route");
        
		Log.d("receivedData", route);
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.i(TAG, "onStart()");

		this.tactileCompass.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(TAG, "onStop()");

		this.tactileCompass.onStop();
	}

	public Location createTestLocation() {
		Location l = new Location(LocationManager.GPS_PROVIDER);
		LAT = experiment.getDestinationLat(route);
		Log.d("lat", ""+LAT);
		LON = experiment.getDestinationLon(route);
		Log.d("lon", ""+LON);
		
		l.setLatitude(LAT);
		l.setLongitude(LON);
		return l;
	}
}
