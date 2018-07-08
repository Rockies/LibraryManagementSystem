package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;
import entity.Collection;
import entity.User;

public class FaverList extends ActionSupport{
	private User user;
	private List<Collection> collections;
	private List<Book> books;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Collection> getCollections() {
		return collections;
	}
	public void setCollections(List<Collection> collections) {
		this.collections = collections;
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		user=(User) session.get("user");
		books=dao.getFaverList(user);
		return SUCCESS;
	} 
}
