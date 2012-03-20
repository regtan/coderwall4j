package org.kirino.coderwall4j.model;

public class User {
	private String userId;
	private String userName;
	private String avaterImgSourceUrl;
	private String discription;
	private Long achievements;
	private Long endorsements;

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

	public Long getAchievements() {
		return achievements;
	}

	public void setAchievements(Long achievements) {
		this.achievements = achievements;
	}

	public Long getEndorsements() {
		return endorsements;
	}

	public void setEndorsements(Long endorsements) {
		this.endorsements = endorsements;
	}

}
