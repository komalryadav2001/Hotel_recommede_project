package org.recommend.service;

import java.util.List;

import org.recommend.model.*;
import org.recommend.repository.*;

public class CityServiceImpl implements CityService{
CityRepository cityRepo = new CityRepositoryImpl();

	@Override
	public boolean isAddNewCity(viewCityListModel cmodel) {
		return cityRepo.isAddNewCity(cmodel);
	}

	@Override
	public List<viewCityListModel> isViewCityList() {
		return cityRepo.isViewCityList();
	}

	@Override
	public boolean isDeleteCityById(int cityid) {
		return cityRepo.isDeleteCity(cityid);
	}

	@Override
	public List<viewCityListModel> isViewCityListByName(String name) {	
		return cityRepo.isViewCityListByName(name);
	}

	@Override
	 public boolean isUpdateCityById(int cityId, String cityName) {
        return cityRepo.isUpdateCityById(cityId, cityName);
    }
}
