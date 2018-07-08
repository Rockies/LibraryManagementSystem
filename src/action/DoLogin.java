package action;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.Dao;
import dao.DaoImp;
import entity.User;

public class DoLogin extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void validate() {
		if (user.getUserName().trim().equals(null) || user.getUserName().trim().equals("")) {
			addFieldError("user.username", "用户名为空");
		} else if (user.getPassword().trim().equals(null) || user.getPassword().trim().equals("")) {
			addFieldError("user.password", "密码为空");
		}
		Dao dao = new DaoImp();
		try {
			boolean isInDb = dao.checkInDb(user);
			if (!isInDb)
				addFieldError("user.userName", "请检查用户名和密码");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String execute() throws SQLException {
		Map<String, Object> session=ActionContext.getContext().getSession();
		Dao dao=new DaoImp();
		user=dao.getUser(user.getUserName());
		session.put("user", user);
		if (user.getUserName().equals("admin")) {
			return "adminLogin";
		} else {
			return "userLogin";
		}

	}
}
