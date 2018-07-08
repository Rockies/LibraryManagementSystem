package action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.*;

public class AddComment extends ActionSupport {
	private User user;
	private Book book;
	private Comment comment;
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
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		Map<String, Object> session = ActionContext.getContext().getSession();
		user=(User) session.get("user");
		System.out.println(user.getUserId());
		System.out.println(book.getBookId());
		System.out.println(comment.getScore());
		dao.addComment(book,user,comment);
		return SUCCESS;
		
	}
}
