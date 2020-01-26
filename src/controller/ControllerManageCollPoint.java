package controller;

import java.sql.SQLException;

import bean.AddressBean;
import bean.CollectionPointBean;
import logic.enums.MesType;
import logic.model.AbstractUser;
import logic.model.Address;
import logic.model.CollectionPoint;
import logic.model.Message;
import logic.model.Singleton;
import logic.persistence.AddressDAO;
import logic.persistence.CollectionPointDAO;
import logic.persistence.MessageDAO;

public class ControllerManageCollPoint {
	AbstractUser user = Singleton.getInstance().getUser();
	
	
	
	public Boolean insert(CollectionPointBean collPointBean) throws SQLException {

		
		
		int id = collPointBean.getId();
		String name = collPointBean.getName();
		double lon = collPointBean.getLongitude();
		double lat = collPointBean.getLatitude();
		AddressBean addrBean = collPointBean.getAddress();
		Address addr = new Address(0, addrBean.getAddress(), addrBean.getCity(), addrBean.getPostalCode(), addrBean.getTelephone(), addrBean.getState(), addrBean.getCountry(), addrBean.getZone());
		
		int opening = collPointBean.getOpeningTime();
		int closing = collPointBean.getClosingTime();
		Boolean avail = collPointBean.getIsAvailable();
		CollectionPoint collPoint = new CollectionPoint(id, name, lon, lat, addr, opening, closing, avail);
	    CollectionPointDAO.insert(collPoint);
	    
	    Message m = new Message(0,getDate(), "Nuovo Punto di raccolta", "C'� un nuovo punto di raccolta sulla mappa: " + name, MesType.COLLPOINTBROAD);
		
	    MessageDAO.insert(m, user);
	    
		user.getBoards().addMessage(m);
			    
		return true;
	}
	
	public Boolean delete(CollectionPointBean collPointBean) throws SQLException {
		CollectionPointDAO.delete(collPointBean.getId());
		
	    Message m = new Message(0,getDate(), "Eliminato Punto di raccolta", "E' stato eliminato un punto di raccolta sulla mappa: " + collPointBean, MesType.COLLPOINTBROAD);
		
	    MessageDAO.insert(m, user);
	    
		user.getBoards().addMessage(m);
		
		return true;
	}
	
	public Boolean update(CollectionPointBean collPointBean) throws SQLException {
		int id = collPointBean.getId();
		String name = collPointBean.getName();
		double lon = collPointBean.getLongitude();
		double lat = collPointBean.getLatitude();
		AddressBean addrBean = collPointBean.getAddress();
		Address addr = new Address(0, addrBean.getAddress(), addrBean.getCity(), addrBean.getPostalCode(), addrBean.getTelephone(), addrBean.getState(), addrBean.getCountry(), addrBean.getZone());
		
		int opening = collPointBean.getOpeningTime();
		int closing = collPointBean.getClosingTime();
		Boolean avail = collPointBean.getIsAvailable();
		CollectionPoint collPoint = new CollectionPoint(id, name, lon, lat, addr, opening, closing, avail);
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
