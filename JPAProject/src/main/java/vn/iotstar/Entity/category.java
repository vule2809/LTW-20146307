package vn.iotstar.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category")
@NamedQuery(name = "category.findAll", query = "SELECT c FROM category c")

public class category implements Serializable {
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
	private List<product> products;
	public category(int categoryID, String categoryName, String icon, List<product> products) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
		this.icon = icon;
		this.products = products;
	}
	public category() {
		super();
	}
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
	public List<product> getProducts() {
		return products;
	}
	public void setProducts(List<product> products) {
		this.products = products;
	}
}
