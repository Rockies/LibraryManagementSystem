package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Book;
import entity.Classification;
import entity.Comment;
import entity.Publisher;
import entity.User;

public interface Dao {
	boolean checkInDb(User user) throws SQLException;

	boolean addUser(User user)throws SQLException;

	boolean addClassification(Classification classification)throws SQLException;

	boolean addPublisher(Publisher publisher) throws SQLException;

	List<Publisher> getPublisherList()throws SQLException;

	boolean updatePublisher(Publisher publisher)throws SQLException;

	boolean deletePublisher(Publisher publisher) throws SQLException;

	List<Classification> getClassificationList()throws SQLException;

	boolean addBook(Book book)throws SQLException ;

	List<Book> getBookList()throws SQLException;

	String getPublisherName(int publisherId)throws SQLException;
	
	String getClassificationName(int classificationId)throws SQLException;

	List<Book> filterBook(Book book)throws SQLException;

	List<Book> filterBookByLiked(Book book)throws SQLException;

	boolean addFaver(User user, Book book)throws SQLException;

	User  getUser(String username)throws SQLException;

	List<Book> getFaverList(User user)throws SQLException;

	boolean cancelFaver(User user, Book book)throws SQLException;

	Book getBookInfo(int bookId)throws SQLException;

	double getAvgGrade(int bookId)throws SQLException;
	
	List<Comment> getCommentList(int bookId)throws SQLException;

	boolean addComment(Book book, User user, Comment comment)throws SQLException;
}
