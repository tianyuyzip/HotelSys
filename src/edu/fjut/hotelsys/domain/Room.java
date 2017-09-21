/**
 * 
 */
package edu.fjut.hotelsys.domain;

/**
 * @author joeyang ong
 *
 */
public class Room {
	
	//房间唯一编号
	private Integer roomId;
	private String  roomNo;
	private String  roomType;
	private String[] roomEquipment;
	private String roomEquipmentStr;
	private String  roomStatus;
	private String  roomMemo;
	//房间所属于的分店
	private Hotel   hotel;
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String[] getRoomEquipment() {
		return roomEquipment;
	}
	public void setRoomEquipment(String[] roomEquipment) {
		
		this.roomEquipment = roomEquipment;
		
		StringBuffer sb = new StringBuffer();
		for(String equipment:roomEquipment)
		   sb.append(equipment).append("|");
		if(sb.length()>0)
		   sb.deleteCharAt(sb.length()-1);
		
		this.roomEquipmentStr = sb.toString();
		
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomMemo() {
		return roomMemo;
	}
	public void setRoomMemo(String roomMemo) {
		this.roomMemo = roomMemo;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public String getRoomEquipmentStr() {
		return roomEquipmentStr;
	}
	public void setRoomEquipmentStr(String roomEquipmentStr) {
		this.roomEquipmentStr = roomEquipmentStr;
		this.roomEquipment = roomEquipmentStr.split("\\|");
	}
	

}
