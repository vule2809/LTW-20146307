package Servlets;

public class Product {
	private String ID;
	private String Name;
	private String Type;
	private int Price;
	private String Image;

	
	public Product() {
		
		
	}


	public Product(String id, String name, String type, int price, String image) {
		// TODO Auto-generated constructor stub
		super();
		this.ID = id;
		this.Name = name;
		this.Type  = type;
		this.Price = price;
		this.Image=image;
		
		
	}
	
	public Product(String name) {
		this.Name = name;
	}



	public String getId() {
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		this.Price = price;
	}


	public String getImage() {
		return Image;
	}


	public void setImage(String image) {
		Image = image;
	}


}
