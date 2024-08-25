package org.recommend.model;

public class ReviewModel {
	 private int rid;
	    private String rating;
	    private String review;
	    private String hid;

	    public String getHid() {
	        return hid;
	    }

	    public void setHid(String hid) {
	        this.hid = hid;
	    }

	    public int getRid() {
	        return rid;
	    }

	    public void setRid(int rid) {
	        this.rid = rid;
	    }

	    public String getRating() {
	        return rating;
	    }

	    public void setRating(String rating) {
	        this.rating = rating;
	    }

	    public String getReview() {
	        return review;
	    }

	    public void setReview(String review) {
	        this.review = review;
	    }
	public ReviewModel() {
		super();
	}
	public ReviewModel(int rid, String rating, String review,String hid) {
		super();
		this.rid = rid;
		this.rating = rating;
		this.review = review;
		this.hid = hid;
	}
	
	
}
