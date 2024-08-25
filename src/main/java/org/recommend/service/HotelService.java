package org.recommend.service;

import java.util.List;

import org.recommend.model.HotelModel;


public interface HotelService {
	public boolean isAddNewHotel(HotelModel hmodel);
	public List<HotelModel> isViewHotelList();
	public boolean isDeleteHotelById(int hotelId);
	public boolean isUpdateCityById(int hotelId, String hotelName, String price, String amenities);
	public List<HotelModel> isViewHotelListByCityArea(String city,String area);
	 public List<HotelModel> searchHotelsWithAvgRating(String city, String area);
}
