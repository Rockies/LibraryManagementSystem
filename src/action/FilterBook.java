package action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;

public class FilterBook extends ActionSupport {
	private Book book;
	private List<Book> books;
	private boolean liked;
	
	public boolean isLiked() {
		return liked;
	}
	public void setLiked(boolean liked) {
		System.out.println(liked);
		this.liked = liked;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		
		this.book = book;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		if(liked) {
			books=dao.filterBookByLiked(book);
		}else {
		books=dao.filterBook(book);
		}
		return SUCCESS;
	}
}
