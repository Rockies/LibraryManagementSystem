package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;

public class BookList extends ActionSupport {
	List<Book> books;

	

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		books=dao.getBookList();
		return "success";
	}
}
