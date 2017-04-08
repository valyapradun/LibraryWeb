package by.htp.web.domain;

public class Book {
	private String title;
	private String author;
	private double price;
	private String src;

	public Book(String title, String author, double price, String src) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.src = src;
	}

	public Book() {
	}

	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
