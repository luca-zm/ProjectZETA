package bean;

import logic.enums.Category;

public class ProductBean {
	private int idProductBean;
	private String nameProductBean;
	private int priceBean;
	private int discountPercentageBean;
	private Category categoryBean;
	private String imageProductBean;
	private String descriptionProductBean;
	
	
	
	public ProductBean(int id, String name, int price, int discountPercentage, Category category, String image,
			String description) {
		super();
		this.idProductBean = id;
		this.nameProductBean = name;
		this.priceBean = price;
		this.discountPercentageBean = discountPercentage;
		this.categoryBean = category;
		this.imageProductBean = image;
		this.descriptionProductBean = description;
	}
	public int getIdProductBean() {
		return idProductBean;
	}
	public void setIdProductBean(int id) {
		this.idProductBean = id;
	}
	public String getNameProductBean() {
		return nameProductBean;
	}
	public void setNameProductBean(String name) {
		this.nameProductBean = name;
	}
	public int getPriceBean() {
		return priceBean;
	}
	public void setPriceBean(int price) {
		this.priceBean = price;
	}
	public int getDiscountPercentageBean() {
		return discountPercentageBean;
	}
	public void setDiscountPercentageBean(int discountPercentage) {
		this.discountPercentageBean = discountPercentage;
	}
	public Category getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(Category category) {
		this.categoryBean = category;
	}
	public String getImageProductBean() {
		return imageProductBean;
	}
	public void setImageProductBean(String image) {
		this.imageProductBean = image;
	}
	public String getDescriptionProductBean() {
		return descriptionProductBean;
	}
	public void setDescriptionProductBean(String description) {
		this.descriptionProductBean = description;
	}
	@Override
	public String toString() {
		return "ProductBean [idProductBean=" + idProductBean + ", nameProductBean=" + nameProductBean + ", priceBean="
				+ priceBean + ", discountPercentageBean=" + discountPercentageBean + ", categoryBean=" + categoryBean
				+ ", imageProductBean=" + imageProductBean + ", descriptionProductBean=" + descriptionProductBean + "]";
	}

	
	
}
