package laptopeco.logic.model;

import laptopeco.logic.enums.Category;

public class Product {
	
	private int id;
	private String name;
	private int price;
	private int discountPercentage;
	private Category category;
	private String image;
	private String description;
	
	public Product(int id, String name, int price, int discountPercentage, Category category, String image,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountPercentage = discountPercentage;
		this.category = category;
		this.image = image;
		this.description = description;

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
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", discountPercentage="
				+ discountPercentage + ", category=" + category + ", image=" + image + ", description=" + description
				+ "]";
	}

	
	
	
	
	
	
	

}
