/**
 * 
 */
package edu.fjut.hotelsys.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.fjut.hotelsys.domain.Hotel;
import edu.fjut.hotelsys.utils.HibernateTool;

/**
 * @author joeyang ong
 *
 */
public class HotelDaoHibernateImpl extends HibernateDaoSupport implements HotelDao {

	/* (non-Javadoc)
	 * @see edu.fjut.hotelsys.dao.HotelDao#addHotel(edu.fjut.hotelsys.domain.Hotel)
	 */
	@Override
	public void addHotel(Hotel hotel) {
				
		this.getHibernateTemplate().save(hotel);

	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
	
		return (Hotel)this.getHibernateTemplate().get(Hotel.class, hotelId);

		
	}

	@Override
	public List<Hotel> loadHotels() {
		
		return this.getHibernateTemplate().find("from Hotel h order by h.hotelNo desc");
	}

	@Override
	public void removeHotel(Integer hotelId) {

		Hotel hotel = (Hotel)this.getHibernateTemplate().load(Hotel.class, hotelId);
		this.getHibernateTemplate().delete(hotel);
		
	}

	@Override
	public void updateHotel(Hotel hotel) {

		this.getHibernateTemplate().update(hotel);
		
	}

}
