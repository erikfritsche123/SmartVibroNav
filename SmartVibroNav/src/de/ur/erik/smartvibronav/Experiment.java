package de.ur.erik.smartvibronav;

import android.util.Log;

public class Experiment {
	//Erik
	public static double		LAT_A= 49.0042367;
	public static double		LON_A= 12.1171918;
	
	//Jan
	public static double		LAT_B= 49.0008658;
	public static double		LON_B= 12.1171051;
	
	//Mitterweg
	public static double		LAT_C= 49.0033222;
	public static double		LON_C= 12.1128136;
	
	private String destination;
	
	public Experiment(){
		
	}
	
	public double getDestinationLat(String route){
		Log.d("inDestinationLat","yay");
		if (route.equals("A")||route.equals("a")){
			return LAT_A;
		} else if (route.equals("B")||route.equals("b")){
			return LAT_B;
		} else if (route.equals("C")||route.equals("c")){
			return LAT_C;
		}
		return 0;
	}
	
		
	public double getDestinationLon(String route){
		if (route.equals("A")||route.equals("a")){
			return LON_A;
		} else if (route.equals("B")||route.equals("b")){
			return LON_B;
		} else if (route.equals("C")||route.equals("c")){
			return LON_C;
		}
		return 0;
	}
		
}
	
	


