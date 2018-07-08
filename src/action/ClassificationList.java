package action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Classification;

public class ClassificationList extends ActionSupport{
	List <Classification> classificationList;

	public List<Classification> getClassificationList() {
		return classificationList;
	}

	public void setClassificationList(List<Classification> classificationList) {
		this.classificationList = classificationList;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao=new DaoImp();
		classificationList=dao.getClassificationList();
		return SUCCESS;
	}
}
