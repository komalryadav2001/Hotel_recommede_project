package org.recommend.model;

public class HotelModel {
	private int hid;
	private String hname;
	private String city;
	private String area;
	@Override
	public String toString() {
		return "HotelModel [hid=" + hid + ", hname=" + hname + ", city=" + city + ", area=" + area + ", price=" + price
				+ ", amenities=" + amenities + ", avgRating=" + avgRating + "]";
	}
	private String price;
	private String amenities;
	private double avgRating;
	public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public HotelModel(int hid, String hname, String city, String area, String price, String amenities) {
		super();
		this.hid = hid;
		this.hname = hname;
		this.city = city;
		this.area = area;
		this.price = price;
		this.amenities = amenities;
	}
	public HotelModel() {
		super();
	}
	
}
