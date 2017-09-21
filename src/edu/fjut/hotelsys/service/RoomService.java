/**
 * 
 */
package edu.fjut.hotelsys.service;

import java.util.List;

import edu.fjut.hotelsys.domain.Room;
import edu.fjut.hotelsys.utils.Page;

/**
 * @author joeyang ong
 *
 */
public interface RoomService {
	
	void createRoom(Room room);
	List<Room> loadRooms();
	Room loadRoomById(Integer roomId);
	void updateRoom(Room room);
	void removeRoom(Integer roomId);
	List<Room> loadRooms(RoomQueryHelper helper);
	Page loadPagedRooms(RoomQueryHelper helper,Page page);

}
