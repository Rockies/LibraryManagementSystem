package action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Publisher;

public class PublisherList extends ActionSupport {
	List<Publisher> publisherList;

	public List<Publisher> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<Publisher> publisherList) {
		this.publisherList = publisherList;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		publisherList=dao.getPublisherList();
		return SUCCESS;
	}
}
