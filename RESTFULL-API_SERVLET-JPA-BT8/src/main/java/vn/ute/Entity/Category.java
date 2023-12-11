package vn.ute.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CategoryID;
	@Column(columnDefinition = "nvarchar(200)")
	private String CategoryName;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String icon;

	@JsonManagedReference
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products;

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(int categoryID, String categoryName, String icon, List<Product> products) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
		this.icon = icon;
		this.products = products;
	}

	public Category() {
		super();
	}
}
