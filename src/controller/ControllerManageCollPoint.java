package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CollectionPointBean;
import logic.URLReader;
import logic.enums.MesType;
import logic.model.AbstractUser;
import logic.model.CollectionPoint;
import logic.model.Message;
import logic.model.Singleton;
import logic.persistence.CollectionPointDAO;
import logic.persistence.MessageDAO;

public class ControllerManageCollPoint {
	AbstractUser user = Singleton.getInstance().getUser();
	
	private String markerLayout1 = "&markers=color:green%7Clabel:";
	private String markerLayout2 = "%7C";
	
	private ArrayList<String> urlbox = new ArrayList<>();
	private int count = 0;
	
	
	private String placeaddres = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	private String apikey = "&key=AIzaSyDWaK_dXLPOBO43oLeAkMTrgkh-6qSlnuc";
	
	
	public URL getFinalUrl(String oldurl, double markerlat, double markerlon) throws MalformedURLException {
		
		count +=1;
				
		String lat = Double.toString(markerlat);
		String lon = Double.toString(markerlon);
		String markerLayout = markerLayout1 + Integer.toString(count) + markerLayout2;
		String markcoord = markerLayout + lat + "," + lon;
		urlbox.add(oldurl);
		urlbox.add(apikey);
		urlbox.add(urlbox.size()-1, markcoord );
		String betaurl="";
		
		for(int i=0;i<urlbox.size();i++){
		betaurl = betaurl + urlbox.get(i) + " ";
		}
		
		String url = betaurl.replace(" ", "");
		
		URL urlfin = new URL(url);
		return urlfin;
		
	}
	
	
	
	public URL startUrl() throws SQLException, MalformedURLException {
		ArrayList<CollectionPoint> listCollPoint = CollectionPointDAO.select();
		URL url = new URL("https://maps.googleapis.com/maps/api/staticmap?center=Rome,Italy&zoom=11&size=600x500&maptype=roadmap&key=AIzaSyDWaK_dXLPOBO43oLeAkMTrgkh-6qSlnuc");
		
		count = 0;
		for(CollectionPoint coll : listCollPoint) {
			url = getFinalUrl(url.toString(), coll.getLatitude(), coll.getLongitude());
				
		}
		
		return url;
		
	
	}
	
	
	public String compositore(String indirizzo) {
		String addressin = placeaddres + indirizzo + apikey;
		String addressfin = addressin.replace(" ","%20");
		return addressfin;
	}
	
	
	public double searchlat(String addr) {
		int pos1 = addr.indexOf("\"lat\" : ");
		String newlat = addr.substring(pos1+8, pos1+18);
		return Double.parseDouble(newlat);
		
	}
		
	public double searchlon(String addr) {
		int pos2 = addr.indexOf("\"lng\" : ");
		String newlng = addr.substring(pos2+8, pos2+18);

		return Double.parseDouble(newlng);
		
	}
	

	public Boolean insert(CollectionPointBean collPointBean) throws Exception { //Vuole eccezione personale
		String s = compositore(collPointBean.getAddressCollPointBean());
		URLReader x = new URLReader(s);
		
		
		double lon = searchlon(x.read());
		double lat = searchlat(x.read());
		int id = collPointBean.getIdCollPointBean();
		String name = collPointBean.getNameCollPointBean();
		String addr = collPointBean.getAddressCollPointBean();
		
		int opening = collPointBean.getOpeningTimeBean();
		int closing = collPointBean.getClosingTimeBean();
		CollectionPoint collPoint = new CollectionPoint(id, name, lon, lat, addr, opening, closing);
		CollectionPointDAO.insert(collPoint);
	    
	    Message m = new Message(0,getDate(), "Nuovo Punto di raccolta", "C'� un nuovo punto di raccolta sulla mappa: " + name, MesType.COLLPOINTBROAD);
		
	    MessageDAO.insertBroad(m);
	    
			    
		return true;
	}
	
	public Boolean delete(CollectionPoint collPoint) throws SQLException {
		CollectionPointDAO.delete(collPoint.getId());
		
	    Message m = new Message(0,getDate(), "Eliminato Punto di raccolta", "E' stato eliminato un punto di raccolta sulla mappa: " + collPoint.getName(), MesType.COLLPOINTBROAD);
		
	    MessageDAO.insertBroad(m );
	    
	
		
		return true;
	}
	
	public Boolean update(CollectionPointBean collPointBean) throws SQLException {
		int id = collPointBean.getIdCollPointBean();
		String name = collPointBean.getNameCollPointBean();
		double lon = searchlon(compositore(collPointBean.getAddressCollPointBean()));
		double lat = searchlat(compositore(collPointBean.getAddressCollPointBean()));
		String addr = collPointBean.getAddressCollPointBean();
		
		int opening = collPointBean.getOpeningTimeBean();
		int closing = collPointBean.getClosingTimeBean();
		CollectionPoint collPoint = new CollectionPoint(id, name, lon, lat, addr, opening, closing);
	    CollectionPointDAO.update(collPoint);
		return true;
	}
	
	private String getDate() {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.format(dt);
	}
}