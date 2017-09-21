/**
 * 
 */
package edu.fjut.hotelsys.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import edu.fjut.hotelsys.domain.Hotel;
import edu.fjut.hotelsys.service.HotelService;
import edu.fjut.hotelsys.service.HotelServiceImpl;

/**
 * @author joeyang ong
 * 
 */
public class HotelAction extends BaseAction {

	private Hotel hotel;
	private List<Hotel> hotelList;
	
	private File hotelPic;
	private String hotelPicFileName;
	private String hotelPicContentType;
	
	private HotelService hotelService = null;

	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public File getHotelPic() {
		return hotelPic;
	}

	public void setHotelPic(File hotelPic) {
		this.hotelPic = hotelPic;
	}

	public String getHotelPicFileName() {
		return hotelPicFileName;
	}

	public void setHotelPicFileName(String hotelPicFileName) {
		this.hotelPicFileName = hotelPicFileName;
	}

	public String getHotelPicContentType() {
		return hotelPicContentType;
	}

	public void setHotelPicContentType(String hotelPicContentType) {
		this.hotelPicContentType = hotelPicContentType;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String toInput() throws Exception {
		return "input_hotel_page";
	}

	public String createHotel() throws Exception {
		
		if(hotelPic!=null){
		
			FileInputStream fis = new FileInputStream(hotelPic);
			
			byte[] data = new byte[fis.available()];
			fis.read(data);
	
			this.hotel.setHotelPic(data);
			
		}
		
		hotelService.createHotel(hotel);
		
		return "load_hotel_action";
	}
	
	public String loadHotelPic() throws Exception{
		
		byte[] fileData = hotelService.getHotelPicById(hotel.getHotelNo());
		
		if(fileData==null || fileData.length==0){
			String defaultPicPath = ServletActionContext.getRequest().getRealPath("/pics/default.jpg");
			FileInputStream fis = new FileInputStream(defaultPicPath);
			fileData = new byte[fis.available()];
			fis.read(fileData);
			fis.close();
		}
		
		OutputStream writer = ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType("image/jpeg");
		writer.write(fileData);
		writer.flush();
		writer.close();
		
		return null;
		
	}
	
	//加载所有的分店信息
	public String loadHotels() throws Exception{
		
		hotelList = hotelService.loadHotels();
		
		return "list_hotel_page";
		
	}
	
	//删除分店
	public String removeHotel() throws Exception{
		
		hotelService.removeHotel(hotel.getHotelNo());
		
		return "load_hotel_action";
		
	}
	
	//修改前加载分店信息
	public String preUpdate() throws Exception{
		
		hotel = hotelService.getHotelById(hotel.getHotelNo());
		
		return "update_hotel_page";
		
	}
	
	//修改分店信息
	public String updateHotel() throws Exception{
		
		if(hotelPic!=null){
			FileInputStream fis = new FileInputStream(hotelPic);
			
			byte[] data = new byte[fis.available()];
			fis.read(data);
	
			this.hotel.setHotelPic(data);
		}
		
		if(hotel.getHotelPic()==null || hotel.getHotelPic().length==0){
			hotel.setHotelPic(hotelService.getHotelPicById(hotel.getHotelNo()));
		}
		
		hotelService.updateHotel(hotel);
		
		return "load_hotel_action";
		
	}

}
