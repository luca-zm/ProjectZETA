package laptopeco.logic.model;

import laptopeco.logic.enums.DeliveryStatus;

public class ShipmentTran extends Transaction{

	private String tackingNumber;
	private Product product;
	private  DeliveryStatus deliveryStatus;
	
	
	public ShipmentTran(int id, String date, String tackingNumber, Product product,
			DeliveryStatus deliveryStatus) {
		super(id, date);
		this.tackingNumber = tackingNumber;
		this.product = product;
		this.deliveryStatus = deliveryStatus;
	}


	public String getTackingNumber() {
		return tackingNumber;
	}


	public void setTackingNumber(String tackingNumber) {
		this.tackingNumber = tackingNumber;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	@Override
	public String toString() {
		return "Product: " + product + ", TrackingNumber: " + tackingNumber + ", Status: "+ deliveryStatus + "\n";
	}


	
	
	
}