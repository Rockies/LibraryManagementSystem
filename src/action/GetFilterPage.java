package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Book;
import entity.Classification;
import entity.Publisher;

public class GetFilterPage extends ActionSupport {
	List<Book> books;
	List<Publisher> publisherList;
	List <Classification> classificationList;
	Map<Integer ,String> classMap;
	Map<Integer ,String> publisherMap;

	public List<Classification> getClassificationList() {
		return classificationList;
	}

	public void setClassificationList(List<Classification> classificationList) {
		this.classificationList = classificationList;
	}
	public List<Publisher> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<Publisher> publisherList) {
		this.publisherList = publisherList;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public Map<Integer, String> getClassMap() {
		return classMap;
	}

	public void setClassMap(Map<Integer, String> classMap) {
		this.classMap = classMap;
	}

	public Map<Integer, String> getPublisherMap() {
		return publisherMap;
	}

	public void setPublisherMap(Map<Integer, String> publisherMap) {
		this.publisherMap = publisherMap;
	}

	@Override
	public String execute() throws SQLException {
		Dao dao = new DaoImp();
		books = dao.getBookList();
		publisherList=dao.getPublisherList();
		classificationList=dao.getClassificationList();
		classMap=new HashMap<Integer,String>();
		publisherMap=new HashMap<Integer ,String>();
		classMap.put(-1, "");
		publisherMap.put(-1,"");
		for(Classification classification :classificationList) {
			classMap.put(classification.getClassificationId(), classification.getClassification());
		}
		for(Publisher publisher :publisherList) {
			publisherMap.put(publisher.getPublisherId(), publisher.getPublisher());
		}
		return "success";
	}
}
