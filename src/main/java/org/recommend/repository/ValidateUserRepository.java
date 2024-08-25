package org.recommend.repository;

import org.recommend.model.LoginModel;

public interface ValidateUserRepository {
	public LoginModel isValidate(LoginModel model);
}
