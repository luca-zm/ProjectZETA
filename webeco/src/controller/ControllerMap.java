package controller;

import java.util.ArrayList;

public class ControllerMap {
	
	private String place = "https://maps.googleapis.com/maps/api/staticmap?center=Rome,Italy&zoom=11&size=600x400&maptype=roadmap";
	private String apikey = "&key=AIzaSyDWaK_dXLPOBO43oLeAkMTrgkh-6qSlnuc";
	private String markerLayout = "&markers=color:green%7Clabel:G%7C";
	private ArrayList<String> urlbox = new ArrayList<String>();
	
	
	public String getFinalList(double markerlat, double markerlon) {
		
		String lat = Double.toString(markerlat);
		String lon = Double.toString(markerlon);
		String markcoord = markerLayout + lat + "," + lon;
		urlbox.add(place);
		urlbox.add(apikey);
		urlbox.add(urlbox.size()-1, markcoord );
		String betaurl="";
		
		for(int i=0;i<urlbox.size();i++){
		betaurl = betaurl + urlbox.get(i) + " ";
		}
		
		String url = betaurl.replace(" ", "");
		
		System.out.println(url);
		return url;
		
	}

}