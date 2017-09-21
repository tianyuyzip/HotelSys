/**
 * 
 */
package edu.fjut.hotelsys.service;

import java.util.List;

import edu.fjut.hotelsys.dao.HotelDao;
import edu.fjut.hotelsys.dao.HotelDaoHibernateImpl;
import edu.fjut.hotelsys.dao.RoomDao;
import edu.fjut.hotelsys.dao.RoomDaoHibernateImpl;
import edu.fjut.hotelsys.domain.Hotel;
import edu.fjut.hotelsys.domain.Room;
import edu.fjut.hotelsys.utils.Page;

/**
 * @author joeyang ong
 *
 */
public class RoomServiceImpl implements RoomService {
	
	private RoomDao roomDao;
	private HotelDao hotelDao;
		

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	/* (non-Javadoc)
	 * @see edu.fjut.hotelsys.service.RoomService#createRoom(edu.fjut.hotelsys.domain.Room)
	 */
	@Override
	public void createRoom(Room room) {
		
		roomDao.addRoom(room);
		
		Hotel hotel = hotelDao.getHotelById(room.getHotel().getHotelNo());
        hotel.setHotelRoomCnt(hotel.getHotelRoomCnt()+1);
        hotelDao.updateHotel(hotel);
		
	}

	@Override
	public List<Room> loadRooms() {
		return roomDao.loadAll();
	}

	@Override
	public Room loadRoomById(Integer roomId) {
		return roomDao.getRoomById(roomId);
	}

	@Override
	public void updateRoom(Room room) {
		
		Hotel oldHotel = roomDao.getRoomById(room.getRoomId()).getHotel();
		
		//检查是否修改了分店信息
		if(oldHotel.getHotelNo()!=room.getHotel().getHotelNo()){
			Hotel newHotel = hotelDao.getHotelById(room.getHotel().getHotelNo());
			oldHotel.setHotelRoomCnt(oldHotel.getHotelRoomCnt()-1);
			newHotel.setHotelRoomCnt(newHotel.getHotelRoomCnt()+1);
			hotelDao.updateHotel(oldHotel);
			hotelDao.updateHotel(newHotel);
		}
		
		roomDao.updateRoom(room);
	}

	@Override
	public void removeRoom(Integer roomId) {
		
		Hotel hotel = roomDao.getRoomById(roomId).getHotel();
		hotel.setHotelRoomCnt(hotel.getHotelRoomCnt()-1);
		
		roomDao.removeRoom(roomId);
		hotelDao.updateHotel(hotel);		
		
	}

	@Override
	public List<Room> loadRooms(RoomQueryHelper helper) {
		return roomDao.loadRoomsByHelper(helper);
	}

	@Override
	public Page loadPagedRooms(RoomQueryHelper helper, Page page) {
		
		page.setTotalRecNum(roomDao.cntRoomsByHelper(helper));
		page.setPageContent(roomDao.loadScopedRoomsByHelper(helper, page.getStartIndex(), page.getEndIndex()-page.getStartIndex()));
		
		return page;
	}

}
