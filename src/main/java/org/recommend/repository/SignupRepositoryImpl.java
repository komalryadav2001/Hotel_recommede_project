package org.recommend.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.recommend.model.SignupModel;

public class SignupRepositoryImpl extends DB implements SignupRepository {

	@Override
	public boolean isAddNewUser(SignupModel model) {
	        String query = "insert into login (username,password,email)values(?,?,?)";
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, model.getUsername());
	            stmt.setString(2, model.getPassword());
	            stmt.setString(3, model.getEmail());
	            int value = stmt.executeUpdate();
	            return value > 0;
	        } catch (SQLException ex) {
	            System.out.println("Error In SignUpRepository (isAddNewUser): " + ex);
	            return false;
	        }
	}

}
