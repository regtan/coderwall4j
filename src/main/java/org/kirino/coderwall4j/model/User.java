package org.kirino.coderwall4j.model;

public class User {
	private String userId;
	private String userName;
	private String avaterImgSourceUrl;
	private String discription;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAvaterImgSourceUrl() {
		return avaterImgSourceUrl;
	}

	public void setAvaterImgSourceUrl(String avaterImgSourceUrl) {
		this.avaterImgSourceUrl = avaterImgSourceUrl;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
