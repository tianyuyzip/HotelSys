/**
 * 
 */
package edu.fjut.hotelsys.dao;

import java.util.List;

import edu.fjut.hotelsys.domain.Hotel;

/**
 * @author joeyang ong
 *
 */
public interface HotelDao {
	
	void addHotel(Hotel hotel);
	Hotel getHotelById(Integer hotelId);
	List<Hotel> loadHotels();
	void removeHotel(Integer hotelId);
	void updateHotel(Hotel hotel);

}
