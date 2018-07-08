package action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Classification;
import entity.Publisher;
import entity.User;

public class AddBookPage extends ActionSupport{
	List<Classification> listClass;
	List<Publisher> listPublisher;
	Map<Integer ,String> classMap;
	Map<Integer ,String> publisherMap;
	
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
	public List<Classification> getListClass() {
		return listClass;
	}
	public void setListClass(List<Classification> listClass) {
		this.listClass = listClass;
	}
	public List<Publisher> getListPublisher() {
		return listPublisher;
	}
	public void setListPublisher(List<Publisher> listPublisher) {
		this.listPublisher = listPublisher;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		listClass=dao.getClassificationList();
		listPublisher=dao.getPublisherList();
		classMap=new HashMap<Integer,String>();
		publisherMap=new HashMap<Integer ,String>();
		for(Classification classification :listClass) {
			classMap.put(classification.getClassificationId(), classification.getClassification());
		}
		for(Publisher publisher :listPublisher) {
			publisherMap.put(publisher.getPublisherId(), publisher.getPublisher());
		}
		return SUCCESS;
	}
}
