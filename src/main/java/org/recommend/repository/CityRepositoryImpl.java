package org.recommend.repository;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import org.recommend.model.*;

public class CityRepositoryImpl extends DB implements CityRepository{

	@Override
	 public boolean isAddNewCity(viewCityListModel cmodel) {
        String query = "insert into citymaster (name)values(?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cmodel.getCname());
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (SQLException ex) {
            System.out.println("Error In CityRepositoryImpl (isAddNewCity): " + ex);
            return false;
        }
    }
	public List<viewCityListModel> ViewList;
	
	public List<viewCityListModel> isViewCityList() {
		
		try {
			ViewList=new ArrayList<viewCityListModel>();
			stmt=conn.prepareStatement("select *from citymaster");
			rs=stmt.executeQuery();
			while(rs.next()){
				viewCityListModel m=new viewCityListModel();
				m.setCid(rs.getInt(1));
				m.setCname(rs.getString(2));
				this.ViewList.add(m);
			}
			
			return ViewList.size()>0? ViewList:null;
		} catch (Exception e) {
			System.out.println("Error in loginModel"+e);
			return null;
		}
	}

	@Override
	public boolean isDeleteCity(int cityId) {
		try {
			stmt=conn.prepareStatement("delete from citymaster where cid=?");
			stmt.setInt(1, cityId);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error Is In IsDeleteCity: "+ex);
			return false;
		}
	}

	@Override
	public List<viewCityListModel> isViewCityListByName(String name) {
		try {
			ViewList=new ArrayList<viewCityListModel>();
			stmt=conn.prepareStatement("select *from citymaster where name like '%"+name+"%'");
			rs=stmt.executeQuery();
			while(rs.next()){
				viewCityListModel m=new viewCityListModel();
				m.setCid(rs.getInt(1));
				m.setCname(rs.getString(2));
				this.ViewList.add(m);
			}
			return ViewList.size()>0? ViewList:null;
		} catch (Exception e) {
			System.out.println("Error in loginModel"+e);
			return null;
		}
	}

	@Override
	public boolean isUpdateCityById(int cityId, String cityName) {
        String sql = "UPDATE citymaster SET name=? WHERE cid=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cityName);
            stmt.setInt(2, cityId);

            int value = stmt.executeUpdate();
            return value > 0;
        } catch (SQLException ex) {
            System.out.println("Error in isUpdateCityById: " + ex.getMessage());
            return false;
        }
    }
}
