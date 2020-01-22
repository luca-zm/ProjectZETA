package controller;

import java.sql.SQLException;

import bean.AddressBean;
import bean.CollectionPointBean;
import logic.model.Address;
import logic.model.CollectionPoint;
import logic.persistence.AddressDAO;
import logic.persistence.CollectionPointDAO;

public class ControllerManageCollPoint {
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
		return true;
	}
	
	public Boolean delete(CollectionPointBean collPointBean) throws SQLException {
		CollectionPointDAO.delete(collPointBean.getId());
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
}
