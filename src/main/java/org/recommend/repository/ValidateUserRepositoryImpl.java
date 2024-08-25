package org.recommend.repository;

import org.recommend.model.LoginModel;
import org.recommend.model.viewCityListModel;

import java.util.*;
import java.sql.*;
public class ValidateUserRepositoryImpl extends DB implements ValidUserRepository{

	public LoginModel isValidate(LoginModel model) {
		try {
			stmt=conn.prepareStatement("select *from login where username=? and password=?");
			stmt.setString(1, model.getUsername());
			stmt.setString(2, model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next()) {
				model.setLoginType(rs.getString("logintype"));
			}
			return model;
		}
		catch(Exception ex) {
			System.out.println("Error In ValiDateUserRepository: "+ex);
			return null;
		}
	}
/*	public static void main(String x[]) {
		ValidateUserRepositoryImpl vrepoimpl =new ValidateUserRepositoryImpl();
		LoginModel model=new LoginModel();
		model.setUsername("ram");
		model.setPassword("ram");
		vrepoimpl.isValidate(model);
		System.out.println(model);
	}
*/


	
}
