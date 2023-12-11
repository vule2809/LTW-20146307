package vn.iotstar.Entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "product")
@NamedQuery(name = "product.findAll", query = "SELECT p FROM product p")
public class product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	private int store;
	private int amount;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String description;
	@Column(columnDefinition = "nvarchar(255)")
	private String productName;
	private String imageLink;
	private int sellerID;
	private int price;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoryID")
	private category category;
	public product(int productID, int store, int amount, String description, String productName, String imageLink,
			int sellerID, int price, vn.iotstar.Entity.category category) {
		super();
		this.productID = productID;
		this.store = store;
		this.amount = amount;
		this.description = description;
		this.productName = productName;
		this.imageLink = imageLink;
		this.sellerID = sellerID;
		this.price = price;
		this.category = category;
	}
	public product() {
		super();
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public category getCategory() {
		return category;
	}
	public void setCategory(category category) {
		this.category = category;
	}
}
