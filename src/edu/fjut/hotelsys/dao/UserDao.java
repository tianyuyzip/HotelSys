/**
 * 
 */
package edu.fjut.hotelsys.dao;

import edu.fjut.hotelsys.domain.User;

/**
 * @author joeyang ong
 *
 */
public interface UserDao {

	User getUserByNo(String userNo);
	
}
