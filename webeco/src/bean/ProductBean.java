package bean;

import enums.Category;

public class ProductBean {
	private int id;
	private String name;
	private int price;
	private int discountPercentage;
	private Category category;
	private String image;
	private String description;
	private boolean availability;
	
	
	
	public ProductBean(int id, String name, int price, int discountPercentage, Category category, String image,
			String description, boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountPercentage = discountPercentage;
		this.category = category;
		this.image = image;
		this.description = description;
		this.availability = availability;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", name=" + name + ", price=" + price + ", discountPercentage="
				+ discountPercentage + ", category=" + category + ", image=" + image + ", description=" + description
				+ ", availability=" + availability + "]";
	}
	
	
}
