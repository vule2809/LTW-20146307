package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BookModel_20146307 implements Serializable {
	private static final long serialVersionUID = 1L;

	private int bookid;
	private int isbn;
	private String title;
	private String publisher;
	private BigDecimal price;
	private String description;
	private Date publishDate;
	private String coverImage;
	private int quantity;

	public BookModel_20146307() {
		super();
	}

	public BookModel_20146307(int bookid, int isbn, String title, String publisher, BigDecimal price,
			String description, Date publishDate, String coverImage, int quantity) {
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publishDate = publishDate;
		this.coverImage = coverImage;
		this.quantity = quantity;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BookModel_20146307 [bookid=" + bookid + ", isbn=" + isbn + ", title=" + title + ", publisher="
				+ publisher + ", price=" + price + ", description=" + description + ", publishDate=" + publishDate
				+ ", coverImage=" + coverImage + ", quantity=" + quantity + "]";
	}
	
}
