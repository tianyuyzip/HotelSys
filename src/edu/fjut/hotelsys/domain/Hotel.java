/**
 * 
 */
package edu.fjut.hotelsys.domain;

import java.sql.Blob;

/**
 * @author joeyang ong
 *
 */
public class Hotel extends ValueObject {
	
	private Integer hotelNo;
	private String  hotelName;
	private String  hotelAddr;
	private String  hotelPhone;
	private Integer hotelRoomCnt=0;
	private byte[]  hotelPic;
	
	public Integer getHotelNo() {
		return hotelNo;
	}
	public void setHotelNo(Integer hotelNo) {
		this.hotelNo = hotelNo;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddr() {
		return hotelAddr;
	}
	public void setHotelAddr(String hotelAddr) {
		this.hotelAddr = hotelAddr;
	}
	public String getHotelPhone() {
		return hotelPhone;
	}
	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
	public byte[] getHotelPic() {
		return hotelPic;
	}
	public void setHotelPic(byte[] hotelPic) {
		this.hotelPic = hotelPic;
	}
	public Integer getHotelRoomCnt() {
		return hotelRoomCnt;
	}
	public void setHotelRoomCnt(Integer hotelRoomCnt) {
		this.hotelRoomCnt = hotelRoomCnt;
	}	


}
