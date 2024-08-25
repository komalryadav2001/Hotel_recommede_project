package org.recommend.service;

import java.util.List;
import org.recommend.model.viewCityListModel;

public interface CityService {
	public boolean isAddNewCity(viewCityListModel cmodel);
	public List<viewCityListModel> isViewCityList();
	public boolean isDeleteCityById(int cityid);
	public List<viewCityListModel> isViewCityListByName(String name);
	public boolean isUpdateCityById(int cityId,String cityName);
}
