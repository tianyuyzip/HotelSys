/**
 * 
 */
package edu.fjut.hotelsys.dao;

import java.util.List;

import edu.fjut.hotelsys.domain.Room;
import edu.fjut.hotelsys.service.RoomQueryHelper;

/**
 * @author joeyang ong
 *
 */
public interface RoomDao {
	
	void addRoom(Room room);
	List<Room> loadAll();
	Room getRoomById(Integer roomId);
	void updateRoom(Room room);
	void removeRoom(Integer roomId);
	List<Room> loadRoomsByHelper(RoomQueryHelper helper);
	
	/**
	 * 在此查询条件下的记录的总数
	 * @param helper
	 * @return
	 */
	Long cntRoomsByHelper(RoomQueryHelper helper);
	List<Room> loadScopedRoomsByHelper(RoomQueryHelper helper, int beginIdx, int fetchSize);

}
