package org.recommend.repository;

import java.util.List;

import org.recommend.model.*;

public interface CityRepository {
	public boolean isAddNewCity(viewCityListModel model);
	public List<viewCityListModel> isViewCityList();
	public boolean isDeleteCity(int cityId);
	public List<viewCityListModel> isViewCityListByName(String name);
	public boolean isUpdateCityById(int cityId, String cityName);
}
