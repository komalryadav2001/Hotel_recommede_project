package org.recommend.repository;


import org.recommend.model.LoginModel;

public interface ValidUserRepository {
	public LoginModel isValidate(LoginModel model);
	
}
