/**
 * 
 */
package edu.fjut.hotelsys.service;

import edu.fjut.hotelsys.domain.User;

/**
 * @author joeyang ong
 *
 */
public interface UserService {
	
	User checkUser(String userNo, String userPwd);

}
