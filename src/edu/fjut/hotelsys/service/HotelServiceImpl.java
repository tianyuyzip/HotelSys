/**
 * 
 */
package edu.fjut.hotelsys.service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import edu.fjut.hotelsys.dao.HotelDao;
import edu.fjut.hotelsys.dao.HotelDaoHibernateImpl;
import edu.fjut.hotelsys.domain.Hotel;

/**
 * @author joeyang ong
 *
 */
public class HotelServiceImpl implements HotelService {
	
	private HotelDao hotelDao = null;
	

	//反转控制  IOC Inverse Of Controll
	//注入依赖 DI DependencyInjection 
	//DI是IOC的一种实现策略
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	/* (non-Javadoc)
	 * @see edu.fjut.hotelsys.service.HotelService#createHotel(edu.fjut.hotelsys.domain.Hotel)
	 */
	@Override
	public void createHotel(Hotel hotel) {
		
		hotelDao.addHotel(hotel);

	}

	@Override
	public byte[] getHotelPicById(Integer hotelId) {
		
		byte[] data = this.getHotelById(hotelId).getHotelPic();
		
		return data;
		
	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
		//HotelDao hotelDao = new HotelDaoHibernateImpl(); //自行去获得依赖，这种行为称为主动控制
		return hotelDao.getHotelById(hotelId);
	}

	@Override
	public List<Hotel> loadHotels() {
		return hotelDao.loadHotels();
	}

	@Override
	public void removeHotel(Integer hotelId) {
		hotelDao.removeHotel(hotelId);
		
	}

	@Override
	public void updateHotel(Hotel hotel) {
		hotelDao.updateHotel(hotel);		
	}

}
