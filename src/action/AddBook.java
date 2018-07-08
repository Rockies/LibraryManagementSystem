package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;

public class AddBook extends ActionSupport{
	 private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	 public String execute() throws SQLException {
		Dao dao=new DaoImp();
		dao.addBook(book);
		return SUCCESS;
		
	 }
}
