package org.recommend.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.recommend.model.HotelModel;
import org.recommend.model.viewCityListModel;

public class HotelRepositoryImpl extends DB implements HotelRepository {

	@Override
	public boolean isAddNewHotel(HotelModel hmodel) {
		String query = "insert into hotel (hotel_name,city,area,price_per_night,amenities_name) values (?,?,?,?,?);";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, hmodel.getHname());
            stmt.setString(2, hmodel.getCity());
            stmt.setString(3, hmodel.getArea());
            stmt.setString(4, hmodel.getPrice());
            stmt.setString(5, hmodel.getAmenities());
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (SQLException ex) {
            System.out.println("Error In HotelRepositoryImpl (isAddNewHotel): " + ex);
            return false;
        }
	}

	public List<HotelModel> isViewHotelList;
//	@Override
//	public List<HotelModel> isViewHotelList() {
//		try {
//			isViewHotelList=new ArrayList<HotelModel>();
//			stmt=conn.prepareStatement("select *from hotel");
//			rs=stmt.executeQuery();
//			while(rs.next()){
//				HotelModel h=new HotelModel();
//				h.setHid(rs.getInt(1));
//				h.setHname(rs.getString(2));
//				h.setCity(rs.getString(3));
//				h.setArea(rs.getString(4));
//				h.setPrice(rs.getString(5));
//				h.setAmenities(rs.getString(6));
//				this.isViewHotelList.add(h);
//			}
//			
//			return isViewHotelList.size()>0? isViewHotelList:null;
//		} catch (Exception e) {
//			System.out.println("Error in HotelModel"+e);
//			return null;
//		}
//	}
	@Override
	public boolean isDeleteHotelById(int hotelId) {
		try {
			stmt=conn.prepareStatement("delete from hotel where hotel_id=?");
			stmt.setInt(1,  hotelId);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error Is In IsDeleteHotel: "+ex);
			return false;
		}
	}
	@Override
	public boolean isUpdateCityById(int hotelId, String hotelName, String price, String amenities) {
		 String sql = "UPDATE hotel SET hotel_name=?,price_per_night=?,amenities_name=? WHERE hotel_id=?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, hotelName);
	            stmt.setString(2, price);
	            stmt.setString(3, amenities);
	            stmt.setInt(4, hotelId);

	            int value = stmt.executeUpdate();
	            return value > 0;
	        } catch (SQLException ex) {
	            System.out.println("Error in isUpdateHotelById: " + ex.getMessage());
	            return false;
	        }
	}
	@Override
	public List<HotelModel> isViewHotelListByCityArea(String city, String area) {
	    try {
	        isViewHotelList = new ArrayList<HotelModel>();
	        stmt = conn.prepareStatement("select h.hotel_id, h.hotel_name, c.name, h.area, h.price_per_night, h.amenities_name from hotel h inner join citymaster c on c.name=h.city where c.name like '%" + city + "%' AND h.area like '%" + area + "%'");
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            HotelModel h = new HotelModel();
	            h.setHid(rs.getInt(1));
	            h.setHname(rs.getString(2));
	            h.setCity(rs.getString(3));
	            h.setArea(rs.getString(4));
	            h.setPrice(rs.getString(5));
	            h.setAmenities(rs.getString(6));
	            this.isViewHotelList.add(h);
	        }
	        return isViewHotelList.size() > 0 ? isViewHotelList : null;
	    } catch (Exception e) {
	        System.out.println("Error in HotelSearchModel" + e);
	        return null;
	    }
	}
	
	public List<HotelModel> isViewHotelList() {
	    List<HotelModel> hotels = new ArrayList<>();
	    String query = "SELECT * FROM hotel";

	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            HotelModel hotel = new HotelModel();
	            hotel.setHid(rs.getInt("hotel_id"));
	            hotel.setHname(rs.getString("hotel_name"));
	            hotel.setCity(rs.getString("city"));
	            hotel.setArea(rs.getString("area"));
	            hotel.setPrice(rs.getString("price_per_night"));
	            hotel.setAmenities(rs.getString("amenities_name"));
	            hotels.add(hotel);
	        }
	    } catch (SQLException ex) {
	        System.out.println("Error in HotelRepositoryImpl (getAllHotels): " + ex);
	    }
	    
	  //  System.out.println("Hotel in Repo"+hotels);
	    return hotels;
	}

	public List<HotelModel> searchHotelsWithAvgRating(String city, String area) {
	    String query = "SELECT h.hotel_id, h.hotel_name, h.city, h.area, h.price_per_night, h.amenities_name, " +
	                   "COALESCE(AVG(r.rating), 0) AS avg_rating " +
	                   "FROM hotel h " +
	                   "LEFT JOIN review r ON h.hotel_id = r.hotel_id " +
	                   "WHERE h.city LIKE ? AND h.area LIKE ? " +
	                   "GROUP BY h.hotel_id, h.hotel_name, h.city, h.area, h.price_per_night, h.amenities_name " +
	                   "ORDER BY avg_rating DESC";
	    List<HotelModel> hotels = new ArrayList<>();

	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, "%" + city + "%");
	        stmt.setString(2, "%" + area + "%");

	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            HotelModel hotel = new HotelModel();
	            hotel.setHid(rs.getInt("hotel_id"));
	            hotel.setHname(rs.getString("hotel_name"));
	            hotel.setCity(rs.getString("city"));
	            hotel.setArea(rs.getString("area"));
	            hotel.setPrice(rs.getString("price_per_night"));
	            hotel.setAmenities(rs.getString("amenities_name"));
	            hotel.setAvgRating(rs.getDouble("avg_rating"));
	            hotels.add(hotel);
	        }
	    } catch (SQLException ex) {
	        System.out.println("Error in HotelRepositoryImpl (searchHotelsWithAvgRating): " + ex);
	    }
	   // System.out.println("Hotells in Ajax Search "+hotels);
	    return hotels;
	}
}
