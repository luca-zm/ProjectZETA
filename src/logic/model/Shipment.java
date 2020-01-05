package logic.model;

import java.util.Calendar;
import java.util.List;

public class Shipment {

	private int id;
	
	private Calendar shipmentdate;
	
	private Calendar deliverydate;
	
	private String tracking;
	
	private String courierservice;
	
	
	//private List<orderInfo> orderInfo;

	public Shipment() {
	}

	public Shipment(int idshipment, Calendar shipmentdate, Calendar deliverydate, String tracking) {
		this.id = idshipment;
		this.shipmentdate = shipmentdate;
		this.deliverydate = deliverydate;
		this.tracking = tracking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getShipmentdate() {
		return shipmentdate;
	}

	public void setShipmentdate(Calendar shipmentdate) {
		this.shipmentdate = shipmentdate;
	}

	public Calendar getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Calendar deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public String getCourierservice() {
		return courierservice;
	}

	public void setCourierservice(String courierservice) {
		this.courierservice = courierservice;
	}

	/**public List<orderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<orderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}**/

	

}