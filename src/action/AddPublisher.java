package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Publisher;

public class AddPublisher extends ActionSupport{
	private Publisher publisher;

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		boolean isSuc=dao.addPublisher(publisher);
		return isSuc? SUCCESS:"fail";
	}
}
