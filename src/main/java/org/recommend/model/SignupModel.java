package org.recommend.model;

public class SignupModel {
	private String username;
	private String password;
	private String email;
	private String loginType;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public SignupModel() {
		super();
	}
	public SignupModel(String username, String password, String email, String loginType) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.loginType = loginType;
	}
}
