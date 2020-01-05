package logic.model;

public class Product {
	
	private int id;
	private String name;
	private int price;
	private String image;
	private String description;
	private boolean availability;
	
	
	public Product(int id, String name, int price, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}


	public int getId() {return id;}

	public String getName() {return name;}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {return price;}
	

	public String getImage() {return image;}
	
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
	public boolean isAvailability() {
		return availability;
	}
	

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
	
	
	

}
