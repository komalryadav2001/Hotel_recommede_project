package org.recommend.service;

import org.recommend.model.SignupModel;
import org.recommend.repository.SignupRepository;
import org.recommend.repository.SignupRepositoryImpl;

public class SignupServiceImpl implements SignupService{
	SignupRepository signRepo=new SignupRepositoryImpl();
	
	@Override
	public boolean isAddNewUser(SignupModel model) {
		
		return signRepo.isAddNewUser(model);
	}
	
}
