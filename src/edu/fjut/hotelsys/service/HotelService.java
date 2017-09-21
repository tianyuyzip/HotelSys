/**
 * 
 */
package edu.fjut.hotelsys.service;

import java.util.List;

import edu.fjut.hotelsys.domain.Hotel;

/**
 * @author joeyang ong
 *
 */
public interface HotelService {
	
	void createHotel(Hotel hotel);
	byte[] getHotelPicById(Integer hotelId);
	Hotel getHotelById(Integer hotelId);
	List<Hotel> loadHotels();
	void removeHotel(Integer hotelId);
	void updateHotel(Hotel hotel);

}
