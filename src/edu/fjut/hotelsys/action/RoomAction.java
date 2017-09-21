/**
 * 
 */
package edu.fjut.hotelsys.action;

import java.util.List;

import edu.fjut.hotelsys.domain.Hotel;
import edu.fjut.hotelsys.domain.Room;
import edu.fjut.hotelsys.service.HotelService;
import edu.fjut.hotelsys.service.HotelServiceImpl;
import edu.fjut.hotelsys.service.RoomQueryHelper;
import edu.fjut.hotelsys.service.RoomService;
import edu.fjut.hotelsys.service.RoomServiceImpl;
import edu.fjut.hotelsys.utils.Page;

/**
 * @author joeyang ong
 *
 */
//在struts2中，action是不能被复用的，任何的访问都将创建一个新的action对象。
public class RoomAction extends BaseAction {
	
	private Room room;
	private Page page = new Page();
	private List<Hotel> hotelList=null;
	private List<Room> roomList = null;
	private RoomQueryHelper helper = new RoomQueryHelper();
	
	private HotelService hotelService;
	private RoomService roomService;
		
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public RoomQueryHelper getHelper() {
		return helper;
	}

	public void setHelper(RoomQueryHelper helper) {
		this.helper = helper;
	}

	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public String toInput() throws Exception{
		
		//room负责输入界面初始化
		room = new Room();
		room.setRoomType("b");
		room.setRoomEquipment(new String[]{"a","b","c"});
		room.setRoomStatus("d");
		
		hotelList = hotelService.loadHotels();
		
		System.out.println("roomaction input:"+this);
		
		return "input_page";
	}
	
	
	public String createRoom() throws Exception{
		
		//room负责保存新增加的房间信息
		roomService.createRoom(room);
		
		System.out.println("roomaction createroom:"+this);
		
		return "load_rooms_action";
	}
	
	public String loadRooms() throws Exception{
	
		hotelList = hotelService.loadHotels();

		page = roomService.loadPagedRooms(helper,page);
		
		return "list_room_page";
		
	}
	
	
	public String preUpdate() throws Exception{
		
		//room负责
		// 1. 保存要更新的房间编号
		// 2. 保存要更新的房间的原始信息，以便于回填到界面进行回显
		
		room = roomService.loadRoomById(room.getRoomId());

		hotelList = hotelService.loadHotels();	
		
		System.out.println("roomaction preupdate:"+this);
		
		return "update_room_page";
		
	}
	
	public String updateRoom() throws Exception{
		
		//room负责保存已经提交的更新的房间信息
		roomService.updateRoom(room);
		
		
		System.out.println("roomaction updateRoom:"+this);
		
		return "load_rooms_action";
	}
	
	public String removeRoom() throws Exception{
		
		//room负责保存要删除的房间编号
		roomService.removeRoom(room.getRoomId());
		
		System.out.println("roomaction removeRoom:"+this);
		
		return "load_rooms_action";
		
	}


}
