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
//��struts2�У�action�ǲ��ܱ����õģ��κεķ��ʶ�������һ���µ�action����
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
		
		//room������������ʼ��
		room = new Room();
		room.setRoomType("b");
		room.setRoomEquipment(new String[]{"a","b","c"});
		room.setRoomStatus("d");
		
		hotelList = hotelService.loadHotels();
		
		System.out.println("roomaction input:"+this);
		
		return "input_page";
	}
	
	
	public String createRoom() throws Exception{
		
		//room���𱣴������ӵķ�����Ϣ
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
		
		//room����
		// 1. ����Ҫ���µķ�����
		// 2. ����Ҫ���µķ����ԭʼ��Ϣ���Ա��ڻ��������л���
		
		room = roomService.loadRoomById(room.getRoomId());

		hotelList = hotelService.loadHotels();	
		
		System.out.println("roomaction preupdate:"+this);
		
		return "update_room_page";
		
	}
	
	public String updateRoom() throws Exception{
		
		//room���𱣴��Ѿ��ύ�ĸ��µķ�����Ϣ
		roomService.updateRoom(room);
		
		
		System.out.println("roomaction updateRoom:"+this);
		
		return "load_rooms_action";
	}
	
	public String removeRoom() throws Exception{
		
		//room���𱣴�Ҫɾ���ķ�����
		roomService.removeRoom(room.getRoomId());
		
		System.out.println("roomaction removeRoom:"+this);
		
		return "load_rooms_action";
		
	}


}
