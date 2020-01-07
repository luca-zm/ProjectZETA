package logic.model;


import java.util.List;

import logic.enums.DeliveryStatus;

public class Shipment extends Transaction{

	private String tackingNumber;
	private Product product;
	private int price;
	private  DeliveryStatus deliveryStatus;
	
	
	public Shipment(int id, String date, String tackingNumber, Product product, int price,
			DeliveryStatus deliveryStatus) {
		super(id, date);
		this.tackingNumber = tackingNumber;
		this.product = product;
		this.price = price;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	@Override
	public String toString() {
		return "Shipment [tackingNumber=" + tackingNumber + ", product=" + product + ", price=" + price + "]";
	}

	
	
}