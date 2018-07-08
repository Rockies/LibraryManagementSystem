package action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;
import entity.User;

public class AddFaver extends ActionSupport {
	private Book book;
	private User user;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		Map<String, Object> session = ActionContext.getContext().getSession();
		user=(User) session.get("user");
		boolean isSuc= dao.addFaver(user,book);
		return isSuc?SUCCESS:"fail";
	}
}
