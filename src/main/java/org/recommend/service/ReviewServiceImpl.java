package org.recommend.service;

import org.recommend.model.ReviewModel;
import org.recommend.repository.ReviewRepository;
import org.recommend.repository.ReviewRepositoryImpl;

public class ReviewServiceImpl implements ReviewService{
	
	ReviewRepository reviewRope=new ReviewRepositoryImpl();
	
	@Override
	public boolean isAddReview(ReviewModel rmodel) {
		return reviewRope.isAddReview(rmodel);
	}
	
}
