package action;

import java.sql.SQLException;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;
import entity.Comment;

public class BookDetail extends ActionSupport {
	private Book book;
	private List<Comment> comments;
	private double grade;
	
	
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		book=dao.getBookInfo(book.getBookId());
		grade=dao.getAvgGrade(book.getBookId());
		comments=dao.getCommentList(book.getBookId());
		return SUCCESS;
	}
}
