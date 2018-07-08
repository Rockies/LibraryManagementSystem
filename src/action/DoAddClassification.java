package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.Classification;

public class DoAddClassification extends ActionSupport{
	private Classification classification;

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}
	@Override
	public String execute() throws SQLException {
		Dao dao =new DaoImp();
		boolean isSuc=dao.addClassification(classification);
		return isSuc?"success":"fail"; 
	}
}
