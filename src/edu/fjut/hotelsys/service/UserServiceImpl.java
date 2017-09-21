/**
 * 
 */
package edu.fjut.hotelsys.service;

import edu.fjut.hotelsys.dao.UserDao;
import edu.fjut.hotelsys.domain.User;
import edu.fjut.hotelsys.exception.ApplicationException;

/**
 * @author joeyang ong
 *
 */
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see edu.fjut.hotelsys.service.UserService#checkUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkUser(String userNo, String userPwd) {
		
		User user = userDao.getUserByNo(userNo);
		
		if(!user.getUserPwd().equals(userPwd))
			throw new ApplicationException("用户存在，但是密码不正确!");
		
		return user;
	}

}
