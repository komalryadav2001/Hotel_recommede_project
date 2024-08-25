package org.recommend.service;

import java.util.List;

import org.recommend.model.HotelModel;
import org.recommend.model.viewCityListModel;
import org.recommend.repository.HotelRepository;
import org.recommend.repository.HotelRepositoryImpl;

public class HotelServiceImpl implements HotelService{
	HotelRepository hotelRepo=new HotelRepositoryImpl();
	

//	@Override
//	public List<viewCityListModel> isViewCityListByName(String name) {	
//		return cityRepo.isViewCityListByName(name);
//	}

	@Override
	public boolean isAddNewHotel(HotelModel hmodel) {
		return hotelRepo.isAddNewHotel(hmodel);
	}

	@Override
	public List<HotelModel> isViewHotelList() {
		return hotelRepo.isViewHotelList();
	}

	@Override
	public boolean isDeleteHotelById(int hotelId) {
		return hotelRepo.isDeleteHotelById(hotelId);
	}

	@Override
	public boolean isUpdateCityById(int hotelId, String hotelName, String price, String amenities) {
		return hotelRepo.isUpdateCityById(hotelId,hotelName,price,amenities);
	}

	@Override
	public List<HotelModel> isViewHotelListByCityArea(String city, String area) {
		return hotelRepo.isViewHotelListByCityArea(city,area);
	}

	@Override
    public List<HotelModel> searchHotelsWithAvgRating(String city, String area) {
        return hotelRepo.searchHotelsWithAvgRating(city, area);
    }
	

}
