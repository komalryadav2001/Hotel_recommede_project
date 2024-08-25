package org.recommend.repository;

import java.util.List;
import org.recommend.model.HotelModel;
import org.recommend.model.viewCityListModel;

public interface HotelRepository {

	boolean isAddNewHotel(HotelModel hmodel);
	public List<HotelModel> isViewHotelList();
	public boolean isDeleteHotelById(int hotelId);
	boolean isUpdateCityById(int hotelId, String hotelName, String price, String amenities);
	public List<HotelModel> isViewHotelListByCityArea(String city,String area);
	public List<HotelModel> searchHotelsWithAvgRating(String city, String area);
}
