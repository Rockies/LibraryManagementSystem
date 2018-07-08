package action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;
import entity.User;

public class CancelFaver extends ActionSupport {
	private User user;
	private Book book;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		Map<String, Object> session = ActionContext.getContext().getSession();
		user=(User) session.get("user");
		dao.cancelFaver(user,book);
		return SUCCESS;
	}
}
