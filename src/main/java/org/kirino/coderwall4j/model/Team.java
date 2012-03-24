package org.kirino.coderwall4j.model;

import java.util.List;

public class Team {
	private String teamName;
	private String url;
	private String location;
	private String about;
	private String inviteUrl;
	private Integer teamScore;
	private Integer teamRank;
	private List<String> coreSkills;
	private List<User> members;
	private List<TeamAchievement> teamAchievements;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<String> getCoreSkills() {
		return coreSkills;
	}

	public void setCoreSkills(List<String> coreSkills) {
		this.coreSkills = coreSkills;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<TeamAchievement> getTeamAchievements() {
		return teamAchievements;
	}

	public void setTeamAchievements(List<TeamAchievement> teamAchievements) {
		this.teamAchievements = teamAchievements;
	}

	public String getInviteUrl() {
		return inviteUrl;
	}

	public void setInviteUrl(String inviteUrl) {
		this.inviteUrl = inviteUrl;
	}

	public Integer getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(Integer teamScore) {
		this.teamScore = teamScore;
	}

	public Integer getTeamRank() {
		return teamRank;
	}

	public void setTeamRank(Integer teamRank) {
		this.teamRank = teamRank;
	}

}
