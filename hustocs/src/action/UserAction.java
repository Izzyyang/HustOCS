package action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport{
	//用户类型；
	String userType;
	public String login() {
		return "succ";
	}
}
