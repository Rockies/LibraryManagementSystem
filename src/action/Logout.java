package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport {
	@ Override 
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
}
