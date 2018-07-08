package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Publisher;

public class EditPublisher extends ActionSupport{
	private Publisher publisher;

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override 
	public String execute() {
		return SUCCESS;
	}
	public String update() throws SQLException {
		Dao dao=new DaoImp();
		boolean isSuc=dao.updatePublisher(publisher);
		return isSuc?"success":"fail";
	}
	public String delete()throws SQLException{
		Dao dao=new DaoImp();
		boolean isSuc=dao.deletePublisher(publisher);
		return isSuc?"success":"fail";
	}
	
	
}
