/**
 * 
 */
package edu.fjut.hotelsys.action;

import org.apache.struts2.ServletActionContext;

import edu.fjut.hotelsys.domain.User;
import edu.fjut.hotelsys.exception.ApplicationException;
import edu.fjut.hotelsys.service.UserService;

/**
 * @author joeyang ong
 *
 */
public class SecurityAction extends BaseAction {
	
	private UserService userService;
	private User user;
		
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String toLogin() throws Exception{
		return "login_page";
	}
	
	public String login() throws Exception{
		
		try{
		  user = userService.checkUser(user.getUserNo(), user.getUserPwd());
		  //保存登录用户信息到session范围
		  ServletActionContext.getRequest().getSession().setAttribute("loginedUser", user);		  
		  
		}catch(ApplicationException e){
			this.addActionError(e.getMessage());
			return "login_page";
		}
		
		return "main_action";
	}	
	
	
	public String logout() throws Exception{
		ServletActionContext.getRequest().getSession().removeAttribute("loginedUser");	
		ServletActionContext.getRequest().getSession().invalidate();
		return "login_page";
	}
	
	public String main() throws Exception{
		return "main_page";
	}

}
