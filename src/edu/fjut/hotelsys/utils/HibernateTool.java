/**
 * 
 */
package edu.fjut.hotelsys.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author joeyang ong
 *
 */
public class HibernateTool {
	
	private static SessionFactory factory = null;
	
	static{
		Configuration config = new Configuration();
		config.configure("edu/fjut/hotelsys/config/hibernate.cfg.xml");
		factory=config.buildSessionFactory();
	}
	
	public static Session getSession(){
		return factory.openSession();
	}
	

}
