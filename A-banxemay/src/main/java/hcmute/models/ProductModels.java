package hcmute.models;

import java.io.Serializable;

public class ProductModels implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ProductID;
	private String ProductName;
	private String Brand;
	private int Year;
	private String Color;
	private int Price;
	private String Description;
	
	public ProductModels() {
		super();
	}

	public ProductModels(int productID, String productName, String brand, int year, String color, int price,
			String description) {
		super();
		ProductID = productID;
		ProductName = productName;
		Brand = brand;
		Year = year;
		Color = color;
		Price = price;
		Description = description;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "ProductModels [ProductID=" + ProductID + ", ProductName=" + ProductName + ", Brand=" + Brand + ", Year="
				+ Year + ", Color=" + Color + ", Price=" + Price + ", Description=" + Description + "]";
	}
	
	
}
