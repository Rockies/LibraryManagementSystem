package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.User;

public class DoRegister extends ActionSupport {
	private User user;
	private String rePassword;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	@Override public void validate() {
		if(user.getUserName().trim().equals(null)||user.getUserName().trim().equals("")) {
			addFieldError("user.userName","用户名为空" );
			}else if(user.getPassword().trim().equals(null)||user.getPassword().trim().equals("")) {
			addFieldError("user.password","密码为空" );	}
			else if(!user.getPassword().equals(rePassword)) {
				addFieldError("rePassword","两次密码不一致");
			}
			
	}
	@Override public String execute() throws Exception {
		Dao dao=new DaoImp();
		boolean isSuc=dao.addUser(user);
		return isSuc?"success":"fail";
	}
}
