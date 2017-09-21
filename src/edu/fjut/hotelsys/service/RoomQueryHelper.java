/**
 * 
 */
package edu.fjut.hotelsys.service;

import edu.fjut.hotelsys.domain.ValueObject;

/**
 * 
 * 组合查询条件封装对象
 * @author joeyang ong
 *
 */
public class RoomQueryHelper extends ValueObject {
	
	private String qryRoomNo;
	private Integer qryHotelNo;
	private String qryRoomType;
	private String qryRoomStatus;
	
	public String getQryRoomNo() {
		return qryRoomNo;
	}
	public void setQryRoomNo(String qryRoomNo) {
		this.qryRoomNo = qryRoomNo;
	}
	public Integer getQryHotelNo() {
		return qryHotelNo;
	}
	public void setQryHotelNo(Integer qryHotelNo) {
		this.qryHotelNo = qryHotelNo;
	}
	public String getQryRoomType() {
		return qryRoomType;
	}
	public void setQryRoomType(String qryRoomType) {
		this.qryRoomType = qryRoomType;
	}
	public String getQryRoomStatus() {
		return qryRoomStatus;
	}
	public void setQryRoomStatus(String qryRoomStatus) {
		this.qryRoomStatus = qryRoomStatus;
	}


}
