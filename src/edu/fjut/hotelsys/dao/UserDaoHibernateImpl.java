/**
 * 
 */
package edu.fjut.hotelsys.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.fjut.hotelsys.domain.User;
import edu.fjut.hotelsys.exception.DataAccessException;

/**
 * @author joeyang ong
 *
 */
public class UserDaoHibernateImpl extends HibernateDaoSupport implements UserDao {

	/* (non-Javadoc)
	 * @see edu.fjut.hotelsys.dao.UserDao#getUserByNo(java.lang.String)
	 */
	@Override
	public User getUserByNo(String userNo) {
		
		User user = (User)this.getHibernateTemplate().get(User.class, userNo);
		
		if(user==null)
			 throw new DataAccessException("查找的用户不存在!");
		
		return user;
	}

}
