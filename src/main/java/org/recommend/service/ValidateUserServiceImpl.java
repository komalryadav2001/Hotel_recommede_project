package org.recommend.service;

import org.recommend.model.LoginModel;
import org.recommend.repository.*;

public class ValidateUserServiceImpl implements ValidateUserService{
	ValidUserRepository validRepo=new ValidateUserRepositoryImpl();
	public LoginModel isValidate(LoginModel model) {
		return validRepo.isValidate(model);
	}
	
}
