package org.recommend.model;

public class viewCityListModel {
	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public viewCityListModel(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public viewCityListModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
