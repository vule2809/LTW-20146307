package vn.star.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Books")
@NamedQuery(name = "Books.findAll", query = "SELECT c FROM Books c")
public class Books implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookid;
	@Column(columnDefinition = "int")
	private int isbn;
	@Column(columnDefinition = "varchar(200)")
	private String title;
	@Column(columnDefinition = "varchar(200)")
	private String publisher;
	@Column(columnDefinition = "decimal(10,2)")
	private BigDecimal price;
	@Column(columnDefinition = "text")
	private String description;
	@Column(columnDefinition = "date")
	private Date publish_date;
	@Column(columnDefinition = "varchar(200)")
	private String cover_image;
	@Column(columnDefinition = "int")
	private int quanyity;

	public Books(int bookid, int isbn, String title, String publisher, BigDecimal price, String description,
			Date publish_date, String cover_image, int quanyity) {
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quanyity = quanyity;
	}

	public Books() {
		super();
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

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}

	public int getQuanyity() {
		return quanyity;
	}

	public void setQuanyity(int quanyity) {
		this.quanyity = quanyity;
	}

}
