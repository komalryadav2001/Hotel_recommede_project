package org.recommend.repository;

import org.recommend.model.SignupModel;

public interface SignupRepository {
	public boolean isAddNewUser(SignupModel model);
}
