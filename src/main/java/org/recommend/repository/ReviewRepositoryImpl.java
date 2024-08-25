package org.recommend.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.recommend.model.HotelModel;
import org.recommend.model.ReviewModel;

public class ReviewRepositoryImpl extends DB implements ReviewRepository {
	
	HotelModel hmodel=new HotelModel();
	
	@Override
	public boolean isAddReview(ReviewModel rmodel) {
		 String query = "insert into review (rating,review,hotel_id)values(?,?,?)";
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, rmodel.getRating());
	            stmt.setString(2, rmodel.getReview());
	            stmt.setString(3, rmodel.getHid());
	            
	            int value = stmt.executeUpdate();
	            return value > 0;
	        } catch (SQLException ex) {
	            System.out.println("Error In ReviewRepositoryImpl (isAddReview): " + ex);
	            return false;
	        }
	}

}
