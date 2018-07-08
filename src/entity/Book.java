package entity;

import java.sql.Date;

public class Book {
	private int bookId;
	private String isbn;
	private String bookName;
	private String author;
	private int publisherId;
	private int classificationId;
	private Date publisherDate;
	private double price;
	private String publisherName;
	private String classification;
	
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getClassificationId() {
		return classificationId;
	}
	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}
	public Date getPublisherDate() {
		return publisherDate;
	}
	public void setPublisherDate(Date publisherDate) {
		this.publisherDate = publisherDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", bookName=" + bookName + ", author=" + author
				+ ", publisherId=" + publisherId + ", classificationId=" + classificationId + ", publisherDate="
				+ publisherDate + ", price=" + price + ", publisherName=" + publisherName + ", classification="
				+ classification + "]";
	}
	
}
